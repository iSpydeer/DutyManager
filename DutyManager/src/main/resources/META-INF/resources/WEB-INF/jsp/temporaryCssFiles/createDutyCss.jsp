<style>
    body {
        background-color: #E6E8E6;
    }

    .new-duty-card {
        width: 400px;
        border-width: 0;
        border-radius: 12px;
    }

    .input-description {
        height: 80px;
        resize: none;

    }

    .input-executor, .input-supervisor {
        height: 40px;
    }

    .input-description, .input-executor, .input-supervisor, .input-target-date {
        margin-top: 10px;
        border: 2px solid #eee;
        border-radius: 2px;
    }

    .input-description:focus, .input-executor:focus, .input-supervisor:focus, .input-target-date:focus {
        outline: none;
        box-shadow: 0 0 0 0.1rem white, 0 0 0 0.25rem #258cfb;
        border: 2px solid white;

    }

    .btn-check + label.btn {
        border: 2px solid #eee;
    }

    .btn-check:hover + label.btn:hover {
        color: white;
    }

    .btn-low:hover + label.btn:hover {
        background-color: gray;
    }

    .btn-medium:hover + label.btn:hover {
        background-color: orange;
    }

    .btn-high:hover + label.btn:hover {
        background-color: red;
    }

    .btn-low:checked + label.btn {
        background-color: gray;
        border: 2px solid #eee;
        color: white;
        -webkit-box-shadow: 0px 0px 0px 2px gray;
        -moz-box-shadow: 0px 0px 0px 2px gray;
        box-shadow: 0px 0px 0px 2px gray;
    }

    .btn-medium:checked + label.btn {
        background-color: orange;
        border: 2px solid #eee;
        color: white;
        -webkit-box-shadow: 0px 0px 0px 2px orange;
        -moz-box-shadow: 0px 0px 0px 2px orange;
        box-shadow: 0px 0px 0px 2px orange;
    }

    .btn-high:checked + label.btn {
        background-color: red;
        border: 2px solid #eee;
        color: white;
        -webkit-box-shadow: 0px 0px 0px 2px red;
        -moz-box-shadow: 0px 0px 0px 2px red;
        box-shadow: 0px 0px 0px 2px red;
    }
</style>