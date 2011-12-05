<%@ page import="sample.neo4j.Person" %>



<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'friends', 'error')} ">
	<label for="friends">
		<g:message code="person.friends.label" default="Friends" />
		
	</label>
	<g:select name="friends" from="${sample.neo4j.Person.list()}" multiple="multiple" optionKey="id" size="5" value="${personInstance?.friends*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="person.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${personInstance?.name}" />
</div>

