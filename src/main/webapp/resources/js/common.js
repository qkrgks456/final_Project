$(document).ready(function (){
    $('.commentUpdateBtn').on('click', function () {
        console.log($(this).parents('.listForm'));
        $(this).parents('.listForm').addClass('visually-hidden');
        $(this).parents('.listForm').next().removeClass('visually-hidden');
    })
    $('.cmUpdateCancel').on('click', function () {
        $(this).parents('.updateForm').addClass('visually-hidden');
        $(this).parents('.updateForm').prev().removeClass('visually-hidden');
    })
})

