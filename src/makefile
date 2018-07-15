JFLAGS = -g -d
JC = javac
CLASSPATH = ../build/classes/
MKDIR_P = mkdir -p
.SUFFIXES: .java .class
.java.class:
	$(MKDIR_P) ../build/
	$(MKDIR_P) $(CLASSPATH)
	$(JC) $(JFLAGS) $(CLASSPATH) $*.java

CLASSES = \
        ./Client/*.java \
        ./ReplacementAlgorithms/*.java \
        ./nsetcache/*.java
        
default: classes

classes: $(CLASSES:.java=.class)

jar: $(CLASSES:.java=.class)
	jar cvfe ../build/Client.jar Client.Client -C $(CLASSPATH) Client -C $(CLASSPATH) nsetcache -C $(CLASSPATH) ReplacementAlgorithms 
	
clean:
	rm -rf $(CLASSPATH)
	rm -f ../build/*.jar
