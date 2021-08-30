This is repository for test tasks for Sinch interview. Tasks can be found at `cs-home-assignment.pdf` file.

There was nothing told about end of stdin (or I didn't see that), so reading ends on first empty line.

To run **first** problem solution use `./gradlew -q problem1` and then you can input your values.

To run **second** problem solution use `./gradlew -q problem2` and then you can input your values.

To run **third** problem solution use `./gradlew problem3` and then you can send requests with your data. For example:
```
curl localhost:8080/polish-notation -X POST -d "+ + 0.5 1.5 * 4 10
- 2e3 - 700 + 7 * 2 15
- -1.5 * 3.1415 / -7 -2
  100500
  1 2
+ 1"
```