<%@ include file="/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="true"
	var="configurationRenderURL" />

<aui:form action="${configurationActionURL}" method="post" name="fm">

	<aui:input name="${cmd}" type="hidden"
		value="${update}" />

	<aui:input name="redirect" type="hidden"
		value="${configurationRenderURL}" />

	<aui:input name="city" label="City" value="${cityDefault}"/>
	<b>(Examples: Moscow, Delhi, Bangalore, Chennai, Hyderabad)</b>
	<aui:input name="date" label="Date" value="${dateDefault}"/>
	<b>(Note! Enter date in this format: 2017-07-18)</b>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>