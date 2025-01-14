# Approval/Characterisation Testing
Good introduction on approval/characterisation testing [here](https://www.youtube.com/watch?v=jAMVtMesHqk) and [here](https://www.youtube.com/watch?v=5H2s1knHUlA).

# Refactoring Legacy Code
Good course on this [here](https://courses.cd.training/courses/take/refactoring-tutorial/texts/22765099-about-this-course).
Summary of the course is shown below.
## Summary of Steps to Refactoring Legacy Code
Legacy code can mean old codes without unit tests.

4 steps to Refactoring Legacy Code:
1) Approval testing: get the reference result with good code coverage to make sure all scenarios are covered
Start refactoring by: 
2) Remove clutters: use Version Control to commit each of these actions in small incremental steps: removing dead code, renaming for better clarity, etc. Rerun approval test for no-behavioural change introduced.
3a) Reduce cyclomatic complexity 
3b) Compose methods by method extraction. Cyclomatic complexity: different path the code can go through (by ifs-else, etc). Rerun approval test to make sure no behavioural changes is introduced. Also, possibly create interface to put a level of abstraction in the code so SOLID principle is respected.
4) Create more tests to cover all scenarios, copy the result as reference result.
