test: MarkdownParse.class

MarkdownParse.class: MarkdownParse.java
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParse.java

test: MarkdownParseTest.class

MarkdownParseTest.class: MarkdownParseTest.java
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java

CLASSPATH = lib/*:.

TryCommonMark.class: TryCommonMark.java
	javac -g -cp $(CLASSPATH) TryCommonMark.java
