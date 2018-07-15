# N - way set associative cache

The N-way set associative cache implies that there are **k** sets, and there can be **N** entries per set.

### Prerequisites

The framework uses Java (>=1.6). Ensure that JDK and JRE are installed.

### Installing

To setup and run the framework,

1. Clone the repository to the workspace
2. Build:
	a) Run make to build and generate the class files
	b) Run make jar to create JAR files
3. The executable Jar files will be created in the build directory: Cache.jar

### Usage

Create a cache object as:

```
Nsetcache clientCache = new Nsetcache(4,2, new LRU());
```

The first parameter defines the N, and the second defines the k. If the replacement object is not provided LRU algorithm is used by default. 

## Code Documentation

The code documentation is present at the url https://anisha9000.bitbucket.io/

