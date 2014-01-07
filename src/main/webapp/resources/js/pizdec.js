$(function () {

    var realPath = $('#realPath').text().trim();

    var initAngle = 0;
    var $arrow = $("#arrow");
    var $device = $('#device');
    var $resultsShareButton = $('#resultsShare');
    var $results = $('#results');
    var $pizdecCustomImage = $('#pizdecCustomImage');

    var $messageFirst = $('#messageFirst');
    var $messageBefore = $('#messageBefore');
    var $messageAdd = $('#messageAdd');
    var $messageType = $('#messageType');
    var $messageAfter = $('#messageAfter');
    var $messageLast = $('#messageLast');

    var imagePath = realPath + "/resources/img/voltmeter_";
    var imageSuffix = ".png";

    var emptyMessage = "Вы же ничего не выбрали! \n Укажите значение на приборчике";

    var xArrow = $arrow.offset().left + $arrow.width();
    var yArrow = $arrow.offset().top;

    var fixed = false;
    var chosenLabelId = -1;

    var messageValues = ["заебись", "ништяк", "чотко", "четенько", "ровно", "херовато", "пиздец", "совсем пиздец", "полный пиздец"];
    var angles = [40, 55, 69, 83, 96, 108, 121, 132, 148];

    var SMALL_ANIMATION_TIME = 250;
    var BIG_ANIMATION_TIME = 2000;

    var init = function() {
        enableUI();
        enableShare();
    };

    var enableShare = function() {
        $resultsShareButton.click(function() {
            doShare();
        });
    };

    var doShare = function() {
        if( chosenLabelId < 0 ) {
            //show error message
            $resultsShareButton.notify(emptyMessage, {
                position: "top",
                className: "error"
            });
            return;
        }
        else {
            $('.notifyjs-bootstrap-base').hide();
        }



        loadNewPage(chosenLabelId);
        changeFinalMessages(chosenLabelId);

        //show results
        $results.show(SMALL_ANIMATION_TIME, function() {
            $('html, body').animate({
                scrollTop: $results.offset().top
            }, BIG_ANIMATION_TIME);
        });
    };

    var loadNewPage = function(id) {
        var path = "/voltmeter/" + id;
        var url = realPath + path;
        window.history.pushState('', '', url);

        if( ga ) {
            ga('send', 'pageview', {
                'page': path
            });
        }
    };

    var showResultsById = function(id) {
        rotateToId(id);

        //show results
        $results.show();
        changeFinalMessages(id);
    };

    var changeFinalMessages = function(id) {
        //change image
        $pizdecCustomImage.attr("src", imagePath+chosenLabelId+imageSuffix);
        //change text

        var intId = parseInt(id);

        switch (intId) {
            case 0:
            case 1:
            case 2:
                $messageFirst.text("Поздравляем!");
                $messageAfter.text("Что-то не очень в это верится.")
                $messageBefore.text("В вашей жизни");
                $messageAdd.text("все");
                $messageLast.text("В любом случае, нам все равно.")
                break;
            case 3:
            case 4:
                $messageFirst.text("Мдее..");
                $messageBefore.text("В вашей жизни");
                $messageAdd.text("все");
                $messageAfter.text("");
                $messageLast.text("Это очень хорошо. Или нет. Нам все равно.");
                break;
            case 5:
                $messageFirst.text("Мдее..");
                $messageBefore.text("В вашей жизни");
                $messageAdd.text("все как-то");
                $messageAfter.text("");
                $messageLast.text("Это печально. Или нет. Нам все равно.");
                break;
            case 6:
            case 7:
                $messageFirst.text("Воу-воу, палехче!");
                $messageBefore.text("У вас в жизни творится");
                $messageAdd.text("какой-то");
                $messageAfter.text("");
                $messageLast.text("Это очень плохо. Или нет. Нам все равно.");
                break;
            case 8:
                $messageFirst.text("Ну вы вообще даете!");
                $messageBefore.text("Хотите сказать, что вообще");
                $messageAdd.text("");
                $messageAfter.text("");

                var text = "Это очень плохо. Или нет. Нам, в принципе, все равно, но вы можете послушать ";
                text += "<a target='_blank' href='http://pleer.com/tracks/5805443xWiX'>песенку</a> ";
                $messageLast.html(text);
                break;
            default:
                $messageFirst.text("Поздравляем!");
                $messageBefore.text("В вашей жизни");
                $messageAdd.text("");
                $messageAfter.text("");
                $messageLast.text("Это очень хорошо. Или нет. Нам все равно.");
                break;
        }
        $messageType.text(messageValues[chosenLabelId]);
    };

    var enableUI = function() {

        $device.on('mousemove', function(e) {
            var x1 = e.pageX;
            var y1 = e.pageY;

            var angleDeg = Math.atan2(y1 - yArrow, x1 - xArrow) * 180 / Math.PI;
            angleDeg *= -1;

            var angle = 180-angleDeg;

            if( fixed === true ) {
                return;
            }


            if( angle <= angles[0] ) {
                rotate(angles[0]);
            }
            else if( angle >= angles[angles.length-1] ) {
                rotate(angles[angles.length-1]);
            }
            else {
                rotate(angle);
            }

        });

        $('label[id^=label_]').on("click", function(e) {
            var id = $(this).data("number");
            highlightLabel(id, false);

            rotate(angles[id]);
            fixed = true;
            chosenLabelId = id;

            if ($results.is(':visible')) {
                changeFinalMessages(id);
            }
        });

        $('label[id^=label_]').on("mouseover", function(e) {
            var id = $(this).data("number");
            highlightLabel(id, true);
        });

        $('label[id^=label_]').on("mouseout", function(e) {
            var id = $(this).data("number");
            unHighlightLabel(id);
        });

        var requestedId = $('#voltmeterid').text().trim();
        if( requestedId ) {
            if( requestedId >= 0 && requestedId < angles.length ) {
                showResultsById(requestedId);
            }
            else {
                rotate(initAngle);
            }
        }
        else {
            rotate(initAngle);
        }
    };

    var rotate = function(degree) {
        $arrow.css({
            WebkitTransform: 'rotate(' + degree + 'deg)'
        });
        $arrow.css({
            '-moz-transform': 'rotate(' + degree + 'deg)'
        });
    };

    var rotateToId = function(id) {
        if(id >= 0 && id < angles.length ) {
            rotate(angles[id]);
            highlightLabel(id, false);
            chosenLabelId = id;
        }
    };

    var highlightLabel = function(id, mouseover) {
        for(var j = 0; j < angles.length; j++) {
            var label = $('#label_'+j);

            if(id === j) {
                label.addClass("label-selected");
            }
            else {
                if(mouseover === false ) {
                    label.removeClass("label-selected");
                }
                else {
                    if( j !== chosenLabelId ) {
                        label.removeClass("label-selected");
                    }
                }

            }
        }
    };

    var unHighlightLabel = function(id) {
        for(var j = 0; j < angles.length; j++) {
            var label = $('#label_'+j);
            if( j !== chosenLabelId ) {
                label.removeClass("label-selected");
            }
        }
    };

    init();


    (function() {
        if (window.pluso)if (typeof window.pluso.start == "function") return;
        if (window.ifpluso==undefined) { window.ifpluso = 1;
            var d = document, s = d.createElement('script'), g = 'getElementsByTagName';
            s.type = 'text/javascript'; s.charset='UTF-8'; s.async = true;
            s.src = ('https:' == window.location.protocol ? 'https' : 'http')  + '://share.pluso.ru/pluso-like.js';
            var h=d[g]('body')[0];
            h.appendChild(s);
        }})();
});