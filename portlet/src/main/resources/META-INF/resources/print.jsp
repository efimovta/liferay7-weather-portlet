<%@include file="/init.jsp" %>

<c:if test="${empty weather}">
    <h1>Weather(version for print)</h1>
    <h2>Sorry, weather not available now</h2>
</c:if>
<c:if test="${not empty weather}">
    <h1>Weather(version for print)</h1>
    <b>City:</b>${city}
    <br/>
    <b>Date:</b>${date}
    <br/>
    <b>Average temperature:</b>${weather.avgTemp}
    <br/>
    <b>Condition:</b>${weather.condition}
</c:if>

