To generate the EXECUTABLE and execute it from any console do:

Compile the project:

	1. Compile the every file with extension '.cpp' using g++ -c <file1>...
	2. Make the executable with every generated file with extension '.o' using 
	   g++ -o <AppName> <file1>...

	NOTE: If you already have the tool 'make' (from GNU) installed and setted,
 		  You can compile the project with out do the two previous steps.
 		  Do it just executing 'make'. 
 		  In this case, the default name will be 'carsMobility'.

Usage having the executable:
	
	<AppName> -n <number of nodes> -p <increment>

	['n' available options: 4 | 11 | 205]
	['p' available options: 1.1 | 1.2 | 1.3 | 1.7]

	NOTE: the result is stored into the directory called 'output'
