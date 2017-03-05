#File Input and Output
A timer use to measure the time of copying a text file `Big-Alice-In-Wonderland.txt` to a new text file using InputStream, OutputStream, BufferedReader, BufferedWriter and PrintWriter and the stopwatch class to complete the process. It contains 2 classes as follows:
* **FileUtil** which contains 3 methods to copy the text file to another one.
* **FileCopyTask** which contains Runnable tasks to test the methods in the FileUtil class. 

Task | Time
--------------------------------------|-------:
Copy a file byte-by-byte | 5.31953 sec
Copy file 1KB at a time | 0.05833 sec
Copy file 4KB at a time | 0.05215 sec
Copy file 64KB at a time | 0.05041 sec
Copy file 1 line at a time | 0.09359 sec
Copy file 10000 char at a time | 0.06559 sec

From the results above, we can conclude that the time taken to copy the file by byte decreases as we increase the amount of byte to be copied at a time. In other words, the time taken to copy the file is inversely proportional to the amount of byte copied at a time. 
