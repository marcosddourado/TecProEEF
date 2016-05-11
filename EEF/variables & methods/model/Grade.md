# Grade.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package com.mdsgpp.eef.model

## class Grade

#### Private members:

| Type     |        Variable       | Description|
|----------|:---------------------:|------------|
| `double` | elementaryGrade |Contain the grades related to elementary school|
| `double` |    highSchoolGrade    |Contain the grades related to highschool|
| `int`    |       gradeYear       |Contain the year of the grade|
| `State`  |         stateGrade    |Contain the state where grade came from|

#### Public members:

| Return Type |        Method Name       |                         Arguments                        |                Description                |
|:-----------:|:------------------------:|:--------------------------------------------------------:|:-----------------------------------------:|
|             |           Grade          |                            --                            |            Standard constructor           |
|             |           Grade          | `double` elementaryGrade, `double` highSchoolGrade | Constructor with initialization arguments |
|   `double`  | getElementaryGrade |                            --                            |                                           |
|    `void`   | setElementaryGrade |              `double` elementaryGrade              |                                           |
|   `double`  |    getHighSchoolGrade    |                            --                            |                                           |
|    `void`   |    setHighSchoolGrade    |                 `double` highSchoolGrade                 |                                           |
|   `State`   |       getStateGrade      |                            --                            |                                           |
|    `void`   |       setStateGrade      |                    `State` stateGrade                    |                                           |
|    `int`    |       getGradeYear       |                            --                            |                                           |
|    `void`   |       setGradeYear       |                      `int` gradeYear                     |                                           |
