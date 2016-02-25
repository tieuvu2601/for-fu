$(document).ready(function(){
    initSelect2();
    initDateTimePicker();
    avoidHideDropdownMenuWhenClickInside();
    initInputMask();
    initInputNumber();
    initTooltip();
//    initTouchSpin();
    initDateRangePicker();
});

//function initTouchSpin(){
//    $("input.touchSpin").TouchSpin();
//}

function initInputMask(){
    $("[data-mask]").inputmask();
}

function initTooltip(){
    $('[data-toggle="tooltip"]').tooltip();
}

function initInputNumber(){
    $('.input_number').on('keyup', function(e) {
        $(this).val($(this).val().replace(/[^0-9]/g, ''));
    });
}

function initSelect2(){
    $("select").not(".autocomplete").select2();

    //Flat red color scheme for iCheck
    $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
        checkboxClass: 'icheckbox_flat-green',
        radioClass: 'iradio_flat-green'
    });

    //iCheck for checkbox and radio inputs
    $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
        checkboxClass: 'icheckbox_minimal-blue',
        radioClass: 'iradio_minimal-blue'
    });
}

function checkAll(frmId){
    $("#" + frmId + " #checkAll").on("check", function(){
        $("#" + frmId + " input[name=checkList]").each(function(){
            $(this).attr("checked", true);
        });
    });
}

function initDateTimePicker(){
    $('.datepicker').daterangepicker({
        format: "DD/MM/YYYY",
        singleDatePicker : true,
        showDropdowns: true
    });
}

function initDateRangePicker(){
    $('.initdaterangepicker').daterangepicker({
        format: "DD/MM/YYYY",
        "opens": "center",
        startDate: new Date(),
        endDate: new Date()
    })
}



function avoidHideDropdownMenuWhenClickInside(){
    $('.dropdown.keep-open').on({
        "shown.bs.dropdown": function() { this.closable = true; },
        "click":             function() { this.closable = false; },
        "hide.bs.dropdown":  function() { return this.closable; }
    });
}
