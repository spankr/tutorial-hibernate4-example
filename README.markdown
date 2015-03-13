# [Hibernate 4](http://www.hibernate.org/) Example


## What is Hibernate?
Hibernate is a persistance model for Java and .NET.
> Historically, Hibernate facilitated the storage and retrieval of Java domain objects via Object/Relational Mapping.  Today, Hibernate is a collection of related projects enabling developers to utilize POJO-style domain models in their applications in ways extending well beyond Object/Relational Mapping.

###### _from hibernate.org_

Yeah, that's a mouthful.

Anyway, the purpose of this example project is to show how to use Hibernate to interact with a database by mapping classes (aka _Entities_)
to database data.
This is a Java based web application project utilizing Maven but I would imagine someone industrious enough could create a .NET version of this as well.
We also utilize:

* [Spring 3.1.2](http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/jdbc.html)
* [CGLIB 2.2.2](https://github.com/cglib/cglib)
* [Apache Commons DBCP](http://commons.apache.org/proper/commons-dbcp/)
* [SLF4J Logging](http://www.slf4j.org/), for logging purposes


