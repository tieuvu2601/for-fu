$(function () {

    /*//BEGIN CALENDAR
    $("#my-calendar").zabuto_calendar({
        language: "en"
    });
    //END CALENDAR*/

    //BEGIN TO-DO-LIST
    $('.todo-list').slimScroll({
        "width": '100%',
        "height": '250px',
        "wheelStep": 5
    });
    $( ".sortable" ).sortable();
    $( ".sortable" ).disableSelection();
    //END TO-DO-LIST

    $('.tip-top').tooltip({placement: 'top'});
    $('.tip-bottom').tooltip({placement: 'bottom'});
    $('.tip-right').tooltip({placement: 'right'});
    $('.tip-left').tooltip({placement: 'left'});

//    $("input[type=\"checkbox\"], input[type=\"radio\"]").not("[data-switch-no-init]").bootstrapSwitch();
    $('.datePlaceHolder').inputmask("dd/mm/yyyy", {placeholder: "__/__/____"});
//    $('.dateRangePlaceHolder').inputmask("dd/mm/yyyy - dd/mm/yyyy", {placeholder: "__/__/____ - __/__/____"});
    $('.phonePlaceHolder').inputmask("999-999-9999[9]");
});

// Show the document's title on the status bar
window.defaultStatus=document.title;

function trimAndSubmitForm(formName) {
//    $(formName).find('input:text').each(function(){
//        var orgValue = $(this).val();
//        $(this).val($.trim(orgValue));
//    });
//    $(formName).validate({
//        errorPlacement: function(error, element) {},
//        invalidHandler: function(event, validator) {
//            bootbox.alert("Warning", validator.errorList[0].message);
//        }
//    });
    $(formName).validate({
        tooltip_options: {
            '_all_': {trigger: 'focus', placement: 'right'}
        }
    });
    $(formName).submit();
}

function validateDateFormat(inputId, field) {
    if (!isDate($("#" + inputId).val(), inputId)) {
        bootbox.alert("Error", field + ": Invalid date format");
        return false;
    }
    return true;
}

$(document).ready(function() {
    try{
        $('.prevent_type').keydown(function(event){
            if (event.keyCode >= 0){
                event.preventDefault();
                return false;
            }
        });

        $('.onlyNumberInputForceValue').keyup(function(){
            $(this).val(function(el,value){
                value = value.replace(/^(0+)/, '');
                return value.replace(/[^\d]/g,'');
            });
        });

    }catch(err) { console.log('error on ready page: ' + err.message); }

    //form validator
    try{
        $("form").validate({
            tooltip_options: {
                '_all_': {trigger: 'focus'}
            }
        });

    } catch(error){}

    // password field
    $("#btnShowHidePassword").click(function () {
        if ($(this).html() == "Xem") {
            $(this).html("Ẩn");
            var c = $("#password").val();
            $("#password").remove();
            $("<input type='text' class='required nohtml form-control' name='pojo.password' id='password'>").val(c).attr("style", "width:221px").insertBefore("#btnShowHidePassword")
        } else {
            $(this).html("Xem");
            var c = $("#password").val();
            $("#password").remove();
            $("<input type='password' class='required nohtml form-control' name='pojo.password' id='password'>").val(c).attr("style", "width:213px").insertBefore("#btnShowHidePassword")
        }
    });

    $('.not_allow_input').keydown(function(event){
        event.preventDefault();
    });

    adjustPageLinks();
    removeMenuIfNotGranted();

    $('body').click(function() {
        $('.filter-form').hide();
    });

    $('.filter-form').click(function(){
        event.stopPropagation();
    });
    $('.btn-filter').click(function(){
        event.stopPropagation();
        if($('.filter-form').is(':visible')){
            if($('.hasDatepicker').filter(function(){return $(this).is(':visible')}).length){
//                $('.datepicker_range div').datepicker('hide');
                $('.datepicker_range div').hide();
            }
        }
        $(this).closest('.filter-group').find('.filter-form').toggle('slide', {direction: 'right'});
    });

    $('body').on('collapsed.pushMenu expanded.pushMenu', function(){
        setTimeout(updateHeaderAndBodyScrollContainer, 500);
    });
});

function updateHeaderAndBodyScrollContainer(){
    $('.freezeTableHeader').find('.container-scroll-table-header .container-scroll').width($('.container-scroll-content').width());
}

function removeMenuIfNotGranted(){
    if($('#administration_menu').find('li').length == 0){
        $('#administration_menu').remove();
    }
    if($('#report_menu').find('li').length == 0){
        $('#report_menu').remove();
    }
}

function adjustPageLinks(){
    $('.scroll_table_container').each(function(index, containerScrollEl){
        $(this).find('.pagelinks').insertAfter(containerScrollEl);
    });
}

function selectFirstItemSelect2(selectEl){
    if ($.browser.msie) {
        $(selectEl).select2().select2('val','-1');
    }else{
        $(selectEl).select2().select2('val', $('.select2 option:eq(1)').val());
    }
}

function setSelectedValueForSelectMenu(select2Id, valueOfOption){
    $(select2Id).select2('val', valueOfOption);
}


function forceNumericInputsOnly(elementInput){
    $(elementInput).keydown(function(event){
        // Ensure that it is a number and stop the keypress
        if (event.keyCode >= 65 && event.keyCode <= 90) {
            event.preventDefault();
        }
    });
}

function goBack(){
    document.location = document.referrer;
}

function validateRequired(element){
    if($(element).closest('form').length && typeof $(element).closest('form').attr('novalidate') != 'undefined'){
        $(element).closest('form').validate().element(element);
    }
}

function highlightFocusPage(idTab){
    $('#navigation-header-tab li').each(function(index, el){
        $(el).removeClass('active');
    });
    $(idTab).addClass('active');
}

function highlightKppFocusPage(idTab){
    $('#kpp_navigation_bar li').each(function(index, el){
        $(el).removeClass('active');
    });
    $(idTab).addClass('active');
}

function checkAllIfOne(formId, listName, thisStatus, checkboxAll){
    var allCheck = document.getElementById(formId).elements[checkboxAll];
    if(!thisStatus.checked){	//uncheck one  checkbox
        allCheck.checked = false;
        allCheck.parentNode.className = allCheck.parentNode.className.replace('checked', '');
    }else{	//check one  checkbox
        //var checkList = document.getElementsByName(listName);
        var checkList = document.getElementById(formId).elements[listName];
        var listSize = checkList.length;
        if(listSize == undefined) {
            if(checkList.checked) {
                allCheck.checked = true;
                allCheck.parentNode.className = allCheck.parentNode.className + " checked";
            }

        } else {
            if(listSize > 0){ //Have one or more elements
                for(i = 0;i < listSize; i++)
                    if(!checkList[i].checked)
                        return false;
                allCheck.checked = true;
                allCheck.parentNode.className = allCheck.parentNode.className + " checked";
            }
        }

    }
}

function checkAll(formId, listName, thisStatus){
    var list = document.getElementById(formId).elements[listName];
    if(list != null){
        var listSize = list.length;
        if(listSize == undefined) {
            if (!list.disabled) {
                if (thisStatus.checked) {
                    list.checked = true;
                    list.parentNode.className = list.parentNode.className + ' checked';
                }else{
                    list.checked = false;
                    list.parentNode.className = list.parentNode.className.replace('checked', '');
                }
            }
        } else {
            if(listSize > 1) { //Have one or more element
                for(i = 0; i < listSize; i++) {
                    if (!list[i].disabled) {
                        if (thisStatus.checked) {
                            list[i].checked = true;
                            list[i].parentNode.className = list[i].parentNode.className + ' checked';
                        }else{
                            list[i].checked = false;
                            list[i].parentNode.className = list[i].parentNode.className.replace('checked', '');
                        }
                    }
                }
            }
        }
    }
}

function validatePhoneNumber(phoneNumber){
    if($.trim(phoneNumber) != ''){
        var reg = new RegExp("^0{1}\\d{9,10}$");
        return reg.test(phoneNumber);
    }
    return true;
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) != -1) return c.substring(name.length,c.length);
    }
    return "";
}

function setActiveMenu4Admin(menuTab, childActiveTab, isSubChild){
    if(typeof isSubChild != 'ubdefined' && isSubChild){
        $(childActiveTab).closest('ul.treeview-menu').css('display', 'block');
        $(childActiveTab).closest('ul.treeview-menu').closest('li').addClass('active');
        $(childActiveTab).closest('ul.treeview-menu').closest('li.treeview').addClass('active');
        $(childActiveTab).addClass('active');
    }else{
        $(menuTab).addClass('active');
        var childrenListEl = $(menuTab).find('ul').eq(0);
//        if(typeof childrenListEl != 'undefined'){
//            $(childrenListEl).css('display', 'block');
//        }
        $(childActiveTab).addClass('active');
    }
}

function validateSelect2Select(el){
    el.on("select2:select", function (e) {
        if (e) {
            var args = JSON.stringify(e.params, function (key, value) {
                if (value && value.nodeName) return "[DOM node]";
                if (value instanceof $.Event) return "[$.Event]";
                return value;
            });
            var json = JSON.parse(args);
            if(json.data.id != undefined && json.data.id != '' && json.data.id != '-1'){
                $(this).closest('select').find('option:selected').each(function(){
                    if($(this).val() == '-1'){
                        $(this).removeAttr('selected')
                    }
                });
                $(this).closest('select').trigger("change");
            }else{
                $(this).closest('select').find('option:selected').each(function(){
                    if($(this).val() != undefined && $(this).val() != '' && $(this).val() != '-1'){
                        $(this).removeAttr('selected')
                    }
                });
                $(this).closest('select').trigger("change");
            }
        }
    });
}

function collapseSideBarMenu(){
    $("body").addClass('sidebar-collapse').trigger('collapsed.pushMenu');
}

function updateWidth4TableReport(cssSelector){
    var selector = 'first-child';
    if(typeof cssSelector != 'undefined' && cssSelector){
        selector = cssSelector;
    }

    $('.container-scroll-body').find('.container-scroll-content table tbody tr:first-child td').each(function(index, tdEl){
        var width = $(tdEl).outerWidth();
        $('.freezeTableHeader').find(".container-scroll-table-header table thead tr:" + selector +" th:nth-of-type(" + (index + 1)+ ")").width(width);
        $('.freezeTableHeader').find(".container-scroll-table-header table thead tr:" + selector +" th:nth-of-type(" + (index + 1)+ ")").css('min-width', width);
        $('.freezeTableHeader').find(".container-scroll-table-header table thead tr:" + selector +" th:nth-of-type(" + (index + 1)+ ")").css('max-width', width);
        $(tdEl).width(width);
        $(tdEl).css('min-width', width);
        $(tdEl).css('max-width', width);
    });

    $('.container-scroll-body').find('.container-fixed-column table tbody tr:first-child td').each(function(index, tdEl){
        var width = $(tdEl).outerWidth();
        $('.freezeTableHeader').find(".container-fixed-table-header table thead tr:" + selector +" th:nth-of-type(" + (index + 1)+ ")").width(width);
        $('.freezeTableHeader').find(".container-fixed-table-header table thead tr:" + selector +" th:nth-of-type(" + (index + 1)+ ")").css('min-width', width);
        $('.freezeTableHeader').find(".container-fixed-table-header table thead tr:" + selector +" th:nth-of-type(" + (index + 1)+ ")").css('max-width', width);
        $(tdEl).width(width);
        $(tdEl).css('min-width', width);
        $(tdEl).css('max-width', width);
    });

    updateHeaderAndBodyScrollContainer();
}

(function ( $ ) {
    $.fn.showLoading = function() {
        var loadingEl = $("<div class='loading_ajax'><span class='content'>Đang tải dữ liệu. Vui lòng đợi...</span></div>");
        $(loadingEl).height($(document).outerHeight());
        $(loadingEl).width($(document).outerWidth());
        $(this).append(loadingEl);
        $(loadingEl).find('span').css('top', (screen.height / 2) - 100);
    };
    $.fn.removeLoading = function() {
        $(this).find('.loading_ajax').remove();
    };
}( jQuery ));