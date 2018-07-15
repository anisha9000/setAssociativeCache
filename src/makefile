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
        ./nsetcache/*.java \
        ./ReplacementAlgorithms/*.java \
        ./Client/*.java \
        
default: classes

classes: $(CLASSES:.java=.class)

jar: $(CLASSES:.java=.class)
	jar cvfe ../build/Cache.jar -C $(CLASSPATH) ReplacementAlgorithms -C $(CLASSPATH) nsetcache 
	jar cvfe ../build/Client.jar Client.Client -C $(CLASSPATH) Client 
	
clean:
	rm -rf $(CLASSPATH)
	rm -f ../build/*.jar
