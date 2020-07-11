<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8">
<link rel="apple-touch-icon" type="image/png" href="https://static.codepen.io/assets/favicon/apple-touch-icon-5ae1a0698dcc2402e9712f7d01ed509a57814f994c660df9f7a952f3060705ee.png" />
<meta name="apple-mobile-web-app-title" content="CodePen">
<link rel="shortcut icon" type="image/x-icon" href="https://static.codepen.io/assets/favicon/favicon-aec34940fbc1a6e787974dcd360f2c6b63348d4b1f4e06c77743096d55480f33.ico" />
<link rel="mask-icon" type="" href="https://static.codepen.io/assets/favicon/logo-pin-8f3771b1072e3c38bd662872f6b673a722f4b3ca2421637d5596661b4e2132cc.svg" color="#111" />
<title>CodePen - Calendar</title>
<style>
*,
*:before,
*:after {
  box-sizing: border-box;
}
body {
  overflow: hidden;
  font-family: 'Helvetica Neue', Arial, Helvetica, sans-serif;
  font-weight: 100;
  margin: 0 auto;
  padding: 10px;
  width: 480px;
}
.calendar {
  -webkit-transform: translate3d(0, 0, 0);
  -moz-transform: translate3d(0, 0, 0);
  transform: translate3d(0, 0, 0);
  width: 100%;
  margin: 0 auto;
  display: block;
  overflow: hidden;
}
.calendar .circle {
  width: 24px;
  height: 24px;
  background-color: #428bca;
  display: inline-block;
  border-radius: 50%;
}
.calendar .header {
  height: 50px;
  width: 100%;
  background-color: #428bca;
  color: #fff;
  text-align: center;
  position: relative;
  border-top-left-radius: 6px;
  border-top-right-radius: 6px;
  padding-top: 10px;
  height: 100px;
}
.calendar .header .month {
  opacity: 1;
  text-align: center;
  padding: 0px 40px;
  font-size: 2.5em;
  margin-bottom: 0px;
  font-weight: normal;
}
.calendar .header .year {
  text-align: center;
  padding: 0px 40px;
  font-size: 1.5em;
}
.calendar .header h1 {
  margin: 0;
  padding: 0;
  font-size: 20px;
  line-height: 50px;
  font-weight: 100;
  letter-spacing: 1px;
}
.calendar .legend {
  position: absolute;
  bottom: 0;
  width: 100%;
  background: #fff;
  border: 1px solid #E9E9E9;
  line-height: 30px;
}
.ring-left {
  left: 2em;
  position: absolute;
  margin-top: -8px;
}
.ring-right {
  right: 2em;
  position: absolute;
  margin-top: -8px;
}
.ring-left:after,
.ring-right:after,
.ring-left:before,
.ring-right:before {
  background: #fff;
  border-radius: 4px;
  box-shadow: 0 2px 1px rgba(0, 0, 0, 0.25), 0 -1px 1px rgba(0, 0, 0, 0.2);
  content: "";
  display: inline-block;
  margin: 8px;
  height: 32px;
  width: 8px;
}
.left,
.right {
  position: absolute;
  width: 0px;
  height: 0px;
  border-style: solid;
  top: 50%;
  margin-top: -7.5px;
  cursor: pointer;
}
.left {
  border-width: 7.5px 10px 7.5px 0;
  border-color: transparent #FFF transparent transparent;
  left: 20px;
}
.right {
  border-width: 7.5px 0 7.5px 10px;
  border-color: transparent transparent transparent #FFF;
  right: 20px;
}
.month {
  /*overflow: hidden;*/
  opacity: 0;
  margin-bottom: 40px;
  transition: all 0.7s ease;
}
.month.new {
  -webkit-animation: fadeIn 1s ease-out;
  opacity: 1;
}
.month.in.next {
  -webkit-animation: moveFromLeftFadeMonth 0.4s ease-out;
  -moz-animation: moveFromLeftFadeMonth 0.4s ease-out;
  animation: moveFromLeftFadeMonth 0.4s ease-out;
  opacity: 1;
}
.month.in.prev {
  -webkit-animation: moveFromRightFadeMonth 0.4s ease-out;
  -moz-animation: moveFromRightFadeMonth 0.4s ease-out;
  animation: moveFromRightFadeMonth 0.4s ease-out;
  opacity: 1;
}
.month.out.next {
  -webkit-animation: moveToRightFadeMonth 0.4s ease-in;
  -moz-animation: moveToRightFadeMonth 0.4s ease-in;
  animation: moveToRightFadeMonth 0.4s ease-in;
  opacity: 1;
}
.month.out.prev {
  -webkit-animation: moveToLeftFadeMonth 0.4s ease-in;
  -moz-animation: moveToLeftFadeMonth 0.4s ease-in;
  animation: moveToLeftFadeMonth 0.4s ease-in;
  opacity: 1;
}
.week-days {
  padding: 8px 0px;
  background-color: #efefef;
  border-top: 4px solid #2066A3;
}
.week-days .day {
  cursor: default;
}
.week {
  background-color: #fff;
  /* background: #4A4A4A; */
}
.day {
  display: inline-block;
  width: -webkit-calc(14.28571429%);
  padding: 10px;
  text-align: center;
  vertical-align: top;
  cursor: pointer;
  /* background: #4A4A4A; */
  position: relative;
  z-index: 100;
}
.day.other {
  color: #E9E9E9;
}
.day.other .circle {
  background-color: #E9E9E9;
}
.day.today {
  color: #428bca;
  font-weight: normal;
}
.day .day-events {
  list-style: none;
  margin-top: 3px;
  text-align: center;
  height: 12px;
  line-height: 6px;
  overflow: hidden;
}
.day .day-events span {
  vertical-align: top;
  display: inline-block;
  padding: 0;
  margin: 0;
  width: 5px;
  height: 5px;
  line-height: 5px;
  margin: 0 1px;
}
.day-name {
  font-size: 9px;
  text-transform: uppercase;
  margin-bottom: 5px;
  color: rgba(255, 255, 255, 0.5);
  letter-spacing: 0.7px;
}
.day-number {
  font-size: 1em;
  letter-spacing: 1.5px;
}
.blue {
  background: #9ccaeb;
}
.orange {
  background: #f7a700;
}
.green {
  background: #99c66d;
}
.yellow {
  background: #f9e900;
}
.pink {
  background: #FF009B;
}
.details {
  position: relative;
  border: 1px solid #e9e9e9;
  margin-top: 5px;
  border-radius: 2px;
}
.details.in {
  -webkit-animation: moveFromTopFade 0.5s ease both;
  -moz-animation: moveFromTopFade 0.5s ease both;
  animation: moveFromTopFade 0.5s ease both;
}
.details.out {
  -webkit-animation: moveToTopFade 0.5s ease both;
  -moz-animation: moveToTopFade 0.5s ease both;
  animation: moveToTopFade 0.5s ease both;
}
.arrow {
  position: absolute;
  top: -5px;
  left: 50%;
  margin-left: -5px;
  width: 0px;
  height: 0px;
  border-style: solid;
  border-width: 0 5px 5px 5px;
  border-color: transparent transparent #e9e9e9 transparent;
  transition: all 0.7s ease;
}
.arrow:before {
  content: "";
  position: absolute;
  top: 2px;
  left: 50%;
  margin-left: -5px;
  width: 0px;
  height: 0px;
  border-style: solid;
  border-width: 0 5px 5px 5px;
  border-color: transparent transparent #fff transparent;
}
.events {
  padding: 7px 0;
  overflow-y: auto;
  overflow-x: hidden;
}
.events.in {
  -webkit-animation: fadeIn 0.3s ease both;
  -moz-animation: fadeIn 0.3s ease both;
  animation: fadeIn 0.3s ease both;
  -webkit-animation-delay: 0.3s;
  -moz-animation-delay: 0.3s;
  animation-delay: 0.3s;
}
.details.out .events {
  -webkit-animation: fadeOutShrink 0.4s ease both;
  -moz-animation: fadeOutShink 0.4s ease both;
  animation: fadeOutShink 0.4s ease both;
}
.events.out {
  -webkit-animation: fadeOut 0.3s ease both;
  -moz-animation: fadeOut 0.3s ease both;
  animation: fadeOut 0.3s ease both;
}
.event {
  font-size: 16px;
  line-height: 22px;
  letter-spacing: 0.5px;
  padding: 2px 16px;
  vertical-align: top;
}
.event.empty {
  color: #eee;
}
.event span {
  display: inline-block;
  padding: 0 0 0 7px;
}
.event-category {
  height: 10px;
  width: 10px;
  display: inline-block;
  margin: 8px 0 0;
  vertical-align: top;
}
.legend {
  bottom: 0;
  width: 100%;
  background: #fff;
  border: 1px solid #E9E9E9;
  line-height: 30px;
}
.entry {
  position: relative;
  padding: 0 0 0 25px;
  font-size: 13px;
  display: inline-block;
  line-height: 30px;
  background: transparent;
}
.entry:after {
  position: absolute;
  content: '';
  height: 5px;
  width: 5px;
  top: 12px;
  left: 14px;
}
.entry.blue:after {
  background: #9ccaeb;
}
.entry.orange:after {
  background: #f7a700;
}
.entry.green:after {
  background: #99c66d;
}
.entry.yellow:after {
  background: #f9e900;
}
/* slide out to the left */
@keyframes slideOutLeft {
  to {
    transform: translateX(-200%);
  }
}
@-moz-keyframes slideOutLeft {
  to {
    -moz-transform: translateX(-200%);
  }
}
@-webkit-keyframes slideOutLeft {
  to {
    -webkit-transform: translateX(-200%);
  }
}
/* slide in from the right */
@keyframes slideInRight {
  from {
    transform: translateX(200%);
  }
  to {
    transform: translateX(0);
  }
}
@-moz-keyframes slideInRight {
  from {
    -moz-transform: translateX(200%);
  }
  to {
    -moz-transform: translateX(0);
  }
}
@-webkit-keyframes slideInRight {
  from {
    -webkit-transform: translateX(200%);
  }
  to {
    -webkit-transform: translateX(0);
  }
}
/* Animations are cool!  */
@-webkit-keyframes moveFromTopFade {
  from {
    opacity: 0.3;
    height: 0px;
    margin-top: 0px;
    -webkit-transform: translateY(-100%);
  }
}
@-moz-keyframes moveFromTopFade {
  from {
    height: 0px;
    margin-top: 0px;
    -moz-transform: translateY(-100%);
  }
}
@keyframes moveFromTopFade {
  from {
    height: 0px;
    margin-top: 0px;
    transform: translateY(-100%);
  }
}
@-webkit-keyframes moveToTopFade {
  to {
    height: 0px;
    margin-top: 0px;
    opacity: 0.3;
    -webkit-transform: translateY(-100%);
  }
}
@-moz-keyframes moveToTopFade {
  to {
    height: 0px;
    -moz-transform: translateY(-100%);
  }
}
@keyframes moveToTopFade {
  to {
    height: 0px;
    transform: translateY(-100%);
  }
}
@-webkit-keyframes moveToTopFadeMonth {
  to {
    opacity: 0;
    -webkit-transform: translateY(-30%) scale(0.95);
  }
}
@-moz-keyframes moveToTopFadeMonth {
  to {
    opacity: 0;
    -moz-transform: translateY(-30%);
  }
}
@keyframes moveToTopFadeMonth {
  to {
    opacity: 0;
    -moz-transform: translateY(-30%);
  }
}
@-webkit-keyframes moveFromTopFadeMonth {
  from {
    opacity: 0;
    -webkit-transform: translateY(30%) scale(0.95);
  }
}
@-moz-keyframes moveFromTopFadeMonth {
  from {
    opacity: 0;
    -moz-transform: translateY(30%);
  }
}
@keyframes moveFromTopFadeMonth {
  from {
    opacity: 0;
    -moz-transform: translateY(30%);
  }
}
@-webkit-keyframes moveToBottomFadeMonth {
  to {
    opacity: 0;
    -webkit-transform: translateY(30%) scale(0.95);
  }
}
@-moz-keyframes moveToBottomFadeMonth {
  to {
    opacity: 0;
    -webkit-transform: translateY(30%);
  }
}
@keyframes moveToBottomFadeMonth {
  to {
    opacity: 0;
    -webkit-transform: translateY(30%);
  }
}
@-webkit-keyframes moveToLeftFadeMonth {
  to {
    opacity: 0;
    -webkit-transform: translateX(-200%) scale(0.95);
  }
}
@-moz-keyframes moveToLeftFadeMonth {
  to {
    opacity: 0;
    -webkit-transform: translateX(-200%);
  }
}
@keyframes moveToLeftFadeMonth {
  to {
    opacity: 0;
    -webkit-transform: translateX(-200%);
  }
}
@-webkit-keyframes moveToRightFadeMonth {
  to {
    opacity: 0;
    -webkit-transform: translateX(200%) scale(0.95);
  }
}
@-moz-keyframes moveToRightFadeMonth {
  to {
    opacity: 0;
    -webkit-transform: translateX(200%);
  }
}
@keyframes moveToRightFadeMonth {
  to {
    opacity: 0;
    -webkit-transform: translateX(200%);
  }
}
@-webkit-keyframes moveFromBottomFadeMonth {
  from {
    opacity: 0;
    -webkit-transform: translateY(-30%) scale(0.95);
  }
}
@-moz-keyframes moveFromBottomFadeMonth {
  from {
    opacity: 0;
    -webkit-transform: translateY(-30%);
  }
}
@keyframes moveFromBottomFadeMonth {
  from {
    opacity: 0;
    -webkit-transform: translateY(-30%);
  }
}
@-webkit-keyframes moveFromLeftFadeMonth {
  from {
    opacity: 0;
    -webkit-transform: translateX(-200%) scale(0.95);
  }
}
@-webkit-keyframes moveFromRightFadeMonth {
  from {
    opacity: 0;
    -webkit-transform: translateX(200%);
  }
  to {
    opacity: 1;
    -webkit-transform: translateX(0%);
  }
}
@-webkit-keyframes moveToRightFadeMonth {
  to {
    opacity: 1;
    -webkit-transform: translateX(200%);
  }
}
@-webkit-keyframes fadeIn {
  from {
    opacity: 0;
  }
}
@-moz-keyframes fadeIn {
  from {
    opacity: 0;
  }
}
@keyframes fadeIn {
  from {
    opacity: 0;
  }
}
@-webkit-keyframes fadeOut {
  to {
    opacity: 0;
  }
}
@-moz-keyframes fadeOut {
  to {
    opacity: 0;
  }
}
@keyframes fadeOut {
  to {
    opacity: 0;
  }
}
@-webkit-keyframes fadeOutShink {
  to {
    opacity: 0;
    padding: 0px;
    height: 0px;
  }
}
@-moz-keyframes fadeOutShink {
  to {
    opacity: 0;
    padding: 0px;
    height: 0px;
  }
}
@keyframes fadeOutShink {
  to {
    opacity: 0;
    padding: 0px;
    height: 0px;
  }
}
</style>
<script>
  window.console = window.console || function(t) {};
</script>
<script>
  if (document.location.search.match(/type=embed/gi)) {
    window.parent.postMessage("resize", "*");
  }
</script>
</head>
<body translate="no">
<html ng-app="myApp" ng-controller="AppCtrl" lang="en">
<head>
<meta charset="utf-8">
<title>Circle</title>
</head>
<body>
<div calendar class="calendar" id="calendar"></div>
</body>
</html>
<script src="https://static.codepen.io/assets/common/stopExecutionOnTimeout-157cd5b220a5c80d4ff8e0e70ac069bffd87a61252088146915e8726e5d9f147.js"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.8/angular.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment.min.js'></script>
<script id="rendered-js">
!function () {

  var today = moment();

  function Calendar(selector, events) {
    this.el = document.querySelector(selector);
    this.events = events;
    this.maxEvents = this.events.reduce(function (p, c) {
      if (c.events.length > p) {
        return c.events.length;
      } else {
        return p;
      }
    }, 0);
    this.current = moment().date(1);
    this.draw();
    var current = document.querySelector('.today');
    if (current) {
      var self = this;
      window.setTimeout(function () {
        self.openDay(current);
      }, 500);
    }
  }

  Calendar.prototype.draw = function () {
    //Create Header
    this.drawHeader();
    //Draw Month
    this.drawMonth();
    // Draw Legend
    //this.drawLegend();
  };

  Calendar.prototype.drawHeader = function () {
    var self = this;
    if (!this.header) {
      //Create the header elements
      this.header = createElement('div', 'header');
      this.header.className = 'header';

      //this.title = createElement('h1');
      this.title = {
        month: createElement('div', 'month', this.current.format('MMMM')),
        year: createElement('div', 'year', this.current.format('YYYY')) };


      var right = createElement('div', 'right');
      right.addEventListener('click', function () {
        self.nextMonth();
      });

      var left = createElement('div', 'left');
      left.addEventListener('click', function () {
        self.prevMonth();
      });

      var ringLeft = createElement('div', 'ring-left');
      var ringRight = createElement('div', 'ring-right');
      //Append the Elements
      //this.header.appendChild(this.title);
      this.header.appendChild(this.title.month);
      this.header.appendChild(this.title.year);
      this.header.appendChild(ringLeft);
      this.header.appendChild(ringRight);

      this.header.appendChild(right);
      this.header.appendChild(left);
      this.el.appendChild(this.header);
      this.drawWeekDays();
    }

    //this.title.innerHTML = this.current.format('MMMM YYYY');
    this.title.month.innerHTML = this.current.format('MMMM');
    this.title.year.innerHTML = this.current.format('YYYY');
  };

  Calendar.prototype.drawMonth = function () {
    var self = this;

    this.events.forEach(function (event) {
      //ev.date = self.current.clone().date(Math.random() * (29 - 1) + 1);
      event.date = moment(event.date);
    });

    if (this.month) {
      this.oldMonth = this.month;
      this.oldMonth.className = 'month out ' + (self.next ? 'next' : 'prev');
      this.oldMonth.addEventListener('webkitAnimationEnd', function () {
        self.oldMonth.parentNode.removeChild(self.oldMonth);
        self.month = createElement('div', 'month');
        self.backFill();
        self.currentMonth();
        self.fowardFill();
        self.el.appendChild(self.month);
        window.setTimeout(function () {
          self.month.className = 'month in ' + (self.next ? 'next' : 'prev');
        }, 16);
      });
    } else {
      this.month = createElement('div', 'month');
      this.el.appendChild(this.month);
      this.backFill();
      this.currentMonth();
      this.fowardFill();
      this.month.className = 'month new';
    }
  };

  Calendar.prototype.backFill = function () {
    var clone = this.current.clone();
    var dayOfWeek = clone.day();

    if (!dayOfWeek) {
      return;
    }

    clone.subtract('days', dayOfWeek + 1);

    for (var i = dayOfWeek; i > 0; i--) {if (window.CP.shouldStopExecution(0)) break;
      this.drawDay(clone.add('days', 1));
    }window.CP.exitedLoop(0);
  };

  Calendar.prototype.fowardFill = function () {
    var clone = this.current.clone().add('months', 1).subtract('days', 1);
    var dayOfWeek = clone.day();

    if (dayOfWeek === 6) {
      return;
    }

    for (var i = dayOfWeek; i < 6; i++) {if (window.CP.shouldStopExecution(1)) break;
      this.drawDay(clone.add('days', 1));
    }window.CP.exitedLoop(1);
  };

  Calendar.prototype.currentMonth = function () {
    var clone = this.current.clone();

    while (clone.month() === this.current.month()) {if (window.CP.shouldStopExecution(2)) break;
      this.drawDay(clone);
      clone.add('days', 1);
    }window.CP.exitedLoop(2);
  };

  Calendar.prototype.getWeek = function (day) {
    if (!this.week || day.day() === 0) {
      this.week = createElement('div', 'week');
      this.month.appendChild(this.week);
    }
  };

  Calendar.prototype.drawDay = function (day) {
    var self = this;
    this.getWeek(day);

    var todayEvents = this.events.filter(function (event) {
      return event.date.isSame(day, 'day');
    })[0];

    //Outer Day
    var outer = createElement('div', this.getDayClass(day));
    var circle = createElement('span', 'circle');
    if (todayEvents) {
      outer.addEventListener('click', function () {
        self.openDay(this);
      });
      // Circle
      var size = 1 / this.maxEvents * todayEvents.events.length;
      circle.style.webkitTransform = 'scale(' + size + ')';
      circle.style.MozProperty = 'scale(' + size + ')';
      circle.style.transform = 'scale(' + size + ')';
    } else {
      circle.style.webkitTransform = 'scale(0, 0)';
      circle.style.MozProperty = 'scale(0, 0)';
      circle.style.transform = 'scale(0, 0)';
      outer.style.cursor = 'default';
    }

    //Day Name
    var name = createElement('div', 'day-name', day.format('ddd'));

    //Day Number
    var number = createElement('div', 'day-number', day.format('DD'));

    //Events
    var events = createElement('div', 'day-events');
    this.drawEvents(day, events);

    //outer.appendChild(name);
    outer.appendChild(circle);
    outer.appendChild(number);
    //outer.appendChild(events);
    this.week.appendChild(outer);
  };

  Calendar.prototype.drawEvents = function (day, element) {
    if (day.month() === this.current.month()) {
      var todaysEvents = this.events.reduce(function (memo, ev) {
        if (ev.date.isSame(day, 'day')) {
          memo.push(ev);
        }
        return memo;
      }, []);

      todaysEvents.forEach(function (ev) {
        var evSpan = createElement('span', ev.color);
        element.appendChild(evSpan);
      });
    }
  };

  Calendar.prototype.getDayClass = function (day) {
    classes = ['day'];
    if (day.month() !== this.current.month()) {
      classes.push('other');
    } else if (today.isSame(day, 'day')) {
      classes.push('today');
    }
    return classes.join(' ');
  };

  Calendar.prototype.openDay = function (el) {
    var details, arrow;
    var dayNumber = +el.querySelectorAll('.day-number')[0].innerText || +el.querySelectorAll('.day-number')[0].textContent;
    var day = this.current.clone().date(dayNumber);

    var currentOpened = document.querySelector('.details');

    //Check to see if there is an open detais box on the current row
    if (currentOpened && currentOpened.parentNode === el.parentNode) {
      details = currentOpened;
      arrow = document.querySelector('.arrow');
    } else {
      //Close the open events on differnt week row
      //currentOpened && currentOpened.parentNode.removeChild(currentOpened);
      if (currentOpened) {
        currentOpened.addEventListener('webkitAnimationEnd', function () {
          currentOpened.parentNode.removeChild(currentOpened);
        });
        currentOpened.addEventListener('oanimationend', function () {
          currentOpened.parentNode.removeChild(currentOpened);
        });
        currentOpened.addEventListener('msAnimationEnd', function () {
          currentOpened.parentNode.removeChild(currentOpened);
        });
        currentOpened.addEventListener('animationend', function () {
          currentOpened.parentNode.removeChild(currentOpened);
        });
        currentOpened.className = 'details out';
      }

      //Create the Details Container
      details = createElement('div', 'details in');

      //Create the arrow
      var arrow = createElement('div', 'arrow');

      //Create the event wrapper
      details.appendChild(arrow);
      el.parentNode.appendChild(details);
    }

    var todaysEvents = this.events.filter(function (event) {
      return event.date.isSame(day, 'day');
    });

    console.log('m: ', todaysEvents);
    this.renderEvents(todaysEvents, details);

    arrow.style.left = el.offsetLeft - el.parentNode.offsetLeft + el.offsetWidth / 2 + 'px';
  };

  Calendar.prototype.renderEvents = function (events, ele) {
    //Remove any events in the current details element
    var currentWrapper = ele.querySelector('.events');
    var wrapper = createElement('div', 'events in' + (currentWrapper ? ' new' : ''));

    if (events.length < 1) {
      return;
    }
    console.log("events: ", events);
    events[0].events.forEach(function (ev) {
      console.log("evv: ", ev);
      var div = createElement('div', 'event');
      var square = createElement('div', 'event-category ' + ev.color);
      var span = createElement('span', '', ev.name);

      div.appendChild(square);
      div.appendChild(span);
      wrapper.appendChild(div);
    });

    if (!events.length) {
      var div = createElement('div', 'event empty');
      var span = createElement('span', '', 'No Events');

      div.appendChild(span);
      wrapper.appendChild(div);
    }

    if (currentWrapper) {
      currentWrapper.className = 'events out';
      currentWrapper.addEventListener('webkitAnimationEnd', function () {
        currentWrapper.parentNode.removeChild(currentWrapper);
        ele.appendChild(wrapper);
      });
      currentWrapper.addEventListener('oanimationend', function () {
        currentWrapper.parentNode.removeChild(currentWrapper);
        ele.appendChild(wrapper);
      });
      currentWrapper.addEventListener('msAnimationEnd', function () {
        currentWrapper.parentNode.removeChild(currentWrapper);
        ele.appendChild(wrapper);
      });
      currentWrapper.addEventListener('animationend', function () {
        currentWrapper.parentNode.removeChild(currentWrapper);
        ele.appendChild(wrapper);
      });
    } else {
      ele.appendChild(wrapper);
    }
  };

  Calendar.prototype.drawWeekDays = function (el) {
    var self = this;
    this.weekDays = createElement('div', 'week-days');
    var weekdays = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'];
    weekdays.forEach(function (weekday) {
      var day = createElement('span', 'day', weekday);
      self.weekDays.appendChild(day);
    });
    this.el.appendChild(this.weekDays);
  };

  Calendar.prototype.drawLegend = function () {
    var legend = createElement('div', 'legend');
    var calendars = this.events.map(function (e) {
      return e.calendar + '|' + e.color;
    }).reduce(function (memo, e) {
      if (memo.indexOf(e) === -1) {
        memo.push(e);
      }
      return memo;
    }, []).forEach(function (e) {
      var parts = e.split('|');
      var entry = createElement('span', 'entry ' + parts[1], parts[0]);
      legend.appendChild(entry);
    });
    this.el.appendChild(legend);
  };

  Calendar.prototype.nextMonth = function () {
    this.current.add('months', 1);
    this.next = true;
    this.draw();
  };

  Calendar.prototype.prevMonth = function () {
    this.current.subtract('months', 1);
    this.next = false;
    this.draw();
  };

  window.Calendar = Calendar;

  function createElement(tagName, className, innerText) {
    var element = document.createElement(tagName);
    if (className) {
      element.className = className;
    }
    if (innerText) {
      element.innderText = element.textContent = innerText;
    }
    return element;
  }'';
}();

var app = angular.module('myApp', []);
app.controller('AppCtrl', function ($scope) {
  //alert("pepe")
});
app.directive('calendar', [function () {
  return {
    restrict: 'EA',
    scope: {
      date: '=',
      events: '=' },

    link: function (scope, element, attributes) {
      var data = [{
        date: new Date(2017, 0, 1),
        events: [{
          name: 'smokeloader',
          type: 'bot',
          color: 'orange' }] },

      {
        date: new Date(2017, 0, 2),
        events: [{
          name: 'zeus',
          type: 'bot',
          color: 'blue' }] },

      {
        date: new Date(2017, 0, 3),
        events: [{
          name: 'ponyloader',
          type: 'bot',
          color: 'yellow' },
        {
          name: 'aldibot',
          type: 'bot',
          color: 'yellow' },
        {
          name: 'dirtjumper',
          type: 'malware',
          color: 'yellow' }] },

      {
        date: new Date(2017, 0, 4),
        events: [{
          name: 'andromeda',
          type: 'bot',
          color: 'green' }] },

      {
        date: new Date(2017, 0, 5),
        events: [{
          name: 'conficker',
          type: 'bot',
          color: 'orange' },
        {
          name: 'umbraloader',
          type: 'bot',
          color: 'orange' }] },

      {
        date: new Date(2017, 0, 17),
        events: [{
          name: 'aldibot',
          type: 'bot',
          color: 'pink' }] },

      {
        date: new Date(2017, 0, 2),
        events: [{
          name: 'zeus',
          type: 'bot',
          color: 'blue' }] },

      {
        date: new Date(2017, 0, 18),
        events: [{
          name: 'ponyloader',
          type: 'bot',
          color: 'yellow' },
        {
          name: 'aldibot',
          type: 'bot',
          color: 'yellow' },
        {
          name: 'dirtjumper',
          type: 'malware',
          color: 'yellow' }] },,

      {
        date: new Date(2017, 0, 19),
        events: [{
          name: 'zeus',
          type: 'bot',
          color: 'blue' }] },

      {
        date: new Date(2017, 0, 19),
        events: [{
          name: 'ponyloader',
          type: 'bot',
          color: 'yellow' }] }];


      var calendar = new Calendar('#calendar', data);
    } };

}]);
//# sourceURL=pen.js
    </script>
</body>
</html>