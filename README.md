CallCenter
==========
Implement a call center with three levels of employees: respondent, manager and director. An incoming telephone call must be first allocated to a respondent who is free.
If the respondent cannot handle the call, he or she must escalate the call to a manager. If the manager is not free or not able to handle it,then the call should be escalated to a director. 
Design the classes and data structures for this problem. 

Design
==========
Use Chain-of-responsibility pattern in this problem to develop a chain made of call handler, respondent, manager, director.
Use a Rank object to decide who can handle the phone, there is one call handler, and the call handler always dispatch the 
call to respondent, if the respondent cannot handle it, the phone will be moved to manager, and manager to director.
<br>
This design decouple the call to handler and because it is very general, it is very easy to add a new type of call handler.