<style>
    body {
        background-color: #E6E8E6 ;
    }

    .container{
        max-width: none;
    }

    .duty-card {
        width: 270px;
        min-width: 270px;
        height: 390px;
        margin-bottom: 20px;
        border-radius: 12px;
    }

    .duty-card textarea {
        resize: none;
        width: 220px;
        height: 120px;
        border-radius: 12px;
        margin-bottom: 10px;
        background-color: white;
        padding: 10px;
        font-size: 0.9rem;

    }

    .label{
        color: darkgrey;
        font-size: 0.9rem;
        margin-top: 4px;
    }

    .btn-done{
        height: 26px;
        border: none;
        background-color: #258cfb;
    }

    .btn-done:hover{

        background-color: #0070E8;
    }

    .btn-done>img {
        filter: brightness(0) saturate(100%) invert(100%) sepia(0%) saturate(0%) hue-rotate(189deg) brightness(108%) contrast(104%);
    }

    .duty-main-card{
        padding: 10px;
        border-radius: 12px;
        -webkit-box-shadow: 8px 8px 10px -11px rgba(66, 68, 90, 1);
        -moz-box-shadow: 8px 8px 10px -11px rgba(66, 68, 90, 1);
        box-shadow: 8px 8px 10px -11px rgba(66, 68, 90, 1);
        border: 1px solid darkgrey;
        background-color: darkgrey;
    }

    .btn-modify, .btn-delete{
        border: none;
        height: 30px;
        background-color: darkgrey;
        font-size: 0.8rem;
        color: white;
    }

    .btn-modify:hover{
        background-color: green;
        color: white;
    }

    .btn-delete:hover{
        background-color: red;
        color: white;
    }

    .priority-low-sign, .priority-medium-sign, .priority-high-sign{
        font-size: 1.2rem;
    }

    .priority-medium-sign {
        color: orange;
    }

    .priority-high-sign {
        color: red;
    }

    .text-done{
        height: 26px;
        border-radius: 0.2rem;
        border: 1px solid darkgrey;
        text-align: center;
        font-size: 1rem;
    }

    .info-row{
        font-size: 0.8rem;
        color: black;
    }

</style>