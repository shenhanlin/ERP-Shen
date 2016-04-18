/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function UpdateTableHeaders() {
    $(".persist-area").each(function () {

        var el = $(this),
                offset = el.offset(),
                scrollTop = $(window).scrollTop(),
                floatingHeader = $(".floatingHeader", this)

        if ((scrollTop > offset.top) && (scrollTop < offset.top + el.height())) {
            floatingHeader.css({
                "visibility": "visible"
            });
        } else {
            floatingHeader.css({
                "visibility": "hidden"
            });
        }
        ;
    });
}

// DOM Ready      
$(function () {

    var clonedHeaderRow;

    $(".persist-area").each(function () {


        var target = $(".persist-header", this);
        var target_children = target.children();

        var clonedHeaderRow = target.before(target.clone());
        clonedHeaderRow.children().width(function (i, val) {
            return target_children.eq(i).width();
        });
        clonedHeaderRow.addClass("floatingHeader");
    });

    $(window)
            .scroll(UpdateTableHeaders)
            .trigger("scroll");

});
