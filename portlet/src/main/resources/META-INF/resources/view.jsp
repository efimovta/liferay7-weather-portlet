<%@ include file="/init.jsp" %>

<portlet:resourceURL id="/weather/json" var="jsonUrl" />

<c:if test="${empty weather}">
    <h2>Sorry, weather not available now</h2>
</c:if>
<c:if test="${not empty weather}">
    <b>City: </b>${city}
    <br/>
    <b>Date: </b>${date}
    <br/>
    <b>Average temperature: </b>${weather.avgTemp}
    <br/>
    <b>Condition: </b>${weather.condition}
    <br/>
    <b>Json answer: </b><a href="${jsonUrl}">[ Get json ]</a>
</c:if>
