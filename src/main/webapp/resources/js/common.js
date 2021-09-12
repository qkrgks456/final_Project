$(document).ready(function (){
    $(document).on('click','.cmUpdateBtnForm', function () {
        $(this).parents('.listForm').addClass('visually-hidden');
        $(this).parents('.listForm').next().removeClass('visually-hidden');
    })
    $(document).on('click','.cmUpdateCancel', function () {
        $(this).parents('.updateForm').addClass('visually-hidden');
        $(this).parents('.updateForm').prev().removeClass('visually-hidden');
    })
})

