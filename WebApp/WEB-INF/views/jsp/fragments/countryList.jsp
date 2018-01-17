	<option selected="selected">Select Country</option>

<%-- <%@ page import="com.calvinklein.preferredprogram.services.CountryServices" %>
<%@ page import="com.calvinklein.preferredprogram.model.Country" %>
<%@ page import="java.util.ArrayList" %>

<%

CountryServices countryServices = new CountryServices();
ArrayList<Country> countryList = countryServices.getCountryList();

for (Country ctr : countryList){
	out.print("<option value=" + ctr.getCountryId() + ">" + ctr.getCountryName() + "</option>");
}

%>
 --%>
	<option value="CID001">United States</option>
	<option value="CID002">Canada</option> 
