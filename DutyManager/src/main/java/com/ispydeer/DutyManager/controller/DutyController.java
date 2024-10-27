package com.ispydeer.DutyManager.controller;

import com.ispydeer.DutyManager.duty.Duty;
import com.ispydeer.DutyManager.duty.DutyCommand;
import com.ispydeer.DutyManager.mappers.impl.DutyMapper;
import com.ispydeer.DutyManager.repositories.DutyRepository;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

/**
 * Controller for managing duties in the Duty Manager application.
 * Handles requests related to creating, updating, deleting, and viewing duties.
 */
@Controller
public class DutyController {

    private DutyMapper dutyMapper;
    private DutyRepository dutyRepository;

    public DutyController(DutyMapper dutyMapper, DutyRepository dutyRepository) {
        this.dutyMapper = dutyMapper;
        this.dutyRepository = dutyRepository;
    }

    /**
     * Displays the create duty page.
     *
     * @param model the ModelMap to hold attributes for the view
     * @return the name of the view to render
     */
    @RequestMapping(value = "create-duty", method = RequestMethod.GET)
    public String goToCreateDutyPage(ModelMap model) {
        model.put("dutyCommand", new DutyCommand());
        return "createDuty";
    }

    /**
     * Handles the creation of a new duty.
     *
     * @param model the ModelMap to hold attributes for the view
     * @param dutyCommand the command object containing duty details
     * @param bindingResult the result of the binding and validation process
     * @return the view name to redirect to
     */
    @RequestMapping(value = "create-duty", method = RequestMethod.POST)
    public String createDuty(ModelMap model, @Valid DutyCommand dutyCommand, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "createDuty";
        }

        Duty duty = dutyMapper.map(dutyCommand);
        duty.setAssigner(getLoggedInUsername());
        duty.setStartDate(LocalDate.now());
        duty.setIsDone(false);
        dutyRepository.save(duty);
        return "redirect:manage-duties";
    }

    /**
     * Displays the manage duties page.
     *
     * @param model the ModelMap to hold attributes for the view
     * @return the name of the view to render
     */
    @RequestMapping(value = "manage-duties", method = RequestMethod.GET)
    public String goToManageDutiesPage(ModelMap model) {
        String username = getLoggedInUsername();
        List<DutyCommand> dutyCommand = dutyRepository.findDuties(username).stream().map(duty -> dutyMapper.unmap(duty)).toList();
        model.addAttribute("duties", dutyCommand);
        return "manageDuties";
    }

    /**
     * Deletes a duty by its ID.
     *
     * @param id the ID of the duty to delete
     * @return the view name to redirect to
     */
    @RequestMapping(value = "delete-duty")
    public String deleteDuty(@RequestParam int id) {
        dutyRepository.deleteById(id);
        return "redirect:manage-duties";
    }

    /**
     * Displays the update duty page for a specific duty.
     *
     * @param id the ID of the duty to update
     * @param model the ModelMap to hold attributes for the view
     * @return the name of the view to render
     */
    @RequestMapping(value = "update-duty", method = RequestMethod.GET)
    public String goToUpdateDutyPage(@RequestParam int id, ModelMap model) {
        Duty duty = dutyRepository.findById(id).get();
        DutyCommand dutyCommand = dutyMapper.unmap(duty);
        model.addAttribute("dutyCommand", dutyCommand);
        return "createDuty";
    }

    /**
     * Handles the update of an existing duty.
     *
     * @param model the ModelMap to hold attributes for the view
     * @param dutyCommand the command object containing updated duty details
     * @param bindingResult the result of the binding and validation process
     * @return the view name to redirect to
     */
    @RequestMapping(value = "update-duty", method = RequestMethod.POST)
    public String updateDuty(ModelMap model, @Valid DutyCommand dutyCommand, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "createDuty";
        }

        Duty duty = dutyMapper.map(dutyCommand);
        dutyRepository.save(duty);
        return "redirect:manage-duties";
    }

    /**
     * Marks a duty as finished by its ID.
     *
     * @param id the ID of the duty to finish
     * @return the view name to redirect to
     */
    @RequestMapping(value = "finish-duty", method = RequestMethod.POST)
    public String finishDuty(@RequestParam int id) throws Exception {
        Duty duty = dutyRepository.findById(id).orElseThrow(Exception::new);
        duty.setIsDone(true);
        dutyRepository.save(duty);
        return "redirect:manage-duties";
    }

    /**
     * Retrieves the username of the currently logged-in user.
     *
     * @return the username of the logged-in user
     */
    private String getLoggedInUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }


}
