# Interview automation

##Requirements

- JDK 1.8
- Maven 3 (https://maven.apache.org/download.cgi)
- geckodriver (The latest version can be downloaded from https://github.com/mozilla/geckodriver/releases and it must be placed in the root of the project)
- Git (https://git-scm.com/downloads)

## Getting the code

- Get the code using Git
  - Open command line
  - Type `git clone https://github.com/saneladinic/wedoqa.git` and enter username and access token
- Download using browser 
  - Use this link https://github.com/saneladinic/wedoqa/archive/refs/heads/main.zip
  - After download is done, extract the files.

##Running tests

There are two ways of running the tests.

- From IDE (Intellij Idea or Eclipse)
  - Open the command line from the project root or navigate to it
  - Execute the command `mvn eclipse:eclipse` or `mvn idea:idea` depending on you preferred IDE.
  - Open the project in the IDE
  - Locate java file InterviewTest.java in test package com.wedoqa.jobapplication
  - Run the class InterviewTest
- From command line
  - Open the command line from the project root or navigate to it
  - Execute the command `mvn clean test`

###Screenshot location and naming

Screenshots will be located in the root of the project, and named by current date and time e.g. 2021-09-04T11:09:04.651859Z.png.
They will not be deleted automatically.

### Resume file
It is required to change the variable `RESUME_PATH` in the file `src/test/java/com/wedoqa/jobapplication/InterviewTest.java` to an absolute path of an existing file on the file system.
If this is not done `InterviewTest.thirdTest` will fail.
