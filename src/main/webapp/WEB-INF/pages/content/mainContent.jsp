<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>

<div class="row">

    <!--section id="marketing-text">
        <div class="col-md-12 col-sm-12">
            <h1>Пиздецометр</h1>
            <h3>Потому что нам <span class="strikethrough">не</span> все равно!</h3>
        </div>
    </section-->
    <div class="page-header">
        <h1>Пиздецометр <small>Потому что нам <span class="strikethrough">не</span> все равно!</small></h1>
    </div>
</div>
<div class="row">

    <div class="col-md-4">
        <p class="text-p">
            <span class="label label-info">info</span> Это сайт для людей, страдающих легкой формой душевного эксгибиционизма, а также для нытиков и неудачников.
        </p>
        <p class="text-p">
            На работе дедлайн? Жена - злобная сука? Заказчики кидают на деньги? Разбил машину? Муж изменил с подругой? Теперь есть легкий и веселый способ пожаловаться друзьям на все это,
            не вдаваясь в скучные и длинные подробности вашей унылой жизни! Просто укажите на приборе нужный уровень и понажимайте
            там внизу на всякие кнопочки шаринга. И пусть весь мир узнает!
        </p>
        <p class="text-p">
            <span class="label label-warning">warning</span> Если у вас в жизни все прекрасно, вы тоже можете воспользоваться сайтом и в очередной раз рассказать этим мелким людишкам
            о вашей прекрасной жизни на персональной яхте с красавицами.
        </p>
        <p>
            <strong>P.S.</strong> Не ищите здесь смысла, это просто еще один способ увеличения Вселенской Энтропии.
        </p>
    </div>

    <div id="device" class="device col-md-5 col-md-offset-1">

        <label id="label_0" data-number="0" data-fixed="false" class="label label-success device-label label0">заебись</label>
        <label id="label_1" data-number="1" data-fixed="false" class="label label-primary device-label label1">ништяк</label>
        <label id="label_2" data-number="2" data-fixed="false" class="label label-primary device-label label2">чотко</label>
        <label id="label_3" data-number="3" data-fixed="false" class="label label-primary device-label label3">четенько</label>
        <label id="label_4" data-number="4" data-fixed="false" class="label label-warning device-label label4">ровно</label>
        <label id="label_5" data-number="5" data-fixed="false" class="label label-warning device-label label5">херовато</label>
        <label id="label_6" data-number="6" data-fixed="false" class="label label-danger device-label label6">пиздец</label>
        <label id="label_7" data-number="7" data-fixed="false" class="label label-danger device-label label7">пиздец<sup>2</sup></label>
        <label id="label_8" data-number="8" data-fixed="false" class="label label-danger device-label label8">полный пиздец</label>

        <div id="arrow" class="arrow">
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-offset-9">
        <button id="resultsShare" class="btn btn-lg btn-theme device-share"><span class="glyphicon glyphicon-share-alt"></span> Рассказать!</button>
    </div>
</div>


<div id="results" class="row margin-row" style="display: none;">
    <hr/>

    <div class="col-md-8 col-md-offset-5">
        <div class="media">
                    <span class="pull-left" href="#">
                        <img id="pizdecCustomImage" class="media-object" width="200px" src="/resources/img/voltmeter_empty_650_490.png" alt="...">
                    </span>
            <div class="media-body">
                <h4 class="media-heading">
                    <span class="glyphicon glyphicon-info-sign"></span>
                    Ваш личный пиздецометр</h4>
                <div class="media">
                    <p class="text-p">
                        <span id="messageFirst">Поздравляем!</span>
                        <span id="messageBefore">В вашей жизни</span>
                        <span id="messageAdd"></span>
                        <strong id="messageType" class="text-strong">полный пиздец</strong> !
                        <span id="messageAfter"></span>
                        <span id="messageLast">Это очень хорошо. Или нет. Нам все равно.</span>
                    </p>
                    <p class="text-p"><span class="glyphicon glyphicon-share-alt"></span> Расскажите же скорее всем об этом:</p>


                    <div class="pluso" data-background="transparent" data-options="medium,square,line,horizontal,counter,theme=05" data-services="facebook,twitter,vkontakte,google,livejournal,odnoklassniki" data-user="1262715342"></div>
                </div>
            </div>
        </div>
    </div>
</div>