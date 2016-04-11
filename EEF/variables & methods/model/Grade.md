# Grade.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package com.mdsgpp.eef.model

## class Grade

#### Private members:

| Type     |        Variable       | Description|
|----------|:---------------------:|------------|
| `double` | elementarySchoolGrade |grades related to elementary school|
| `double` |    highSchoolGrade    |grades related to highschool|
| `int`    |       gradeYear       |year of the grade|
| `State`  |         stateGrade    |state where grade came from|

#### Public members:

| Return Type |        Method Name       |                         Arguments                        |                Description                |
|:-----------:|:------------------------:|:--------------------------------------------------------:|:-----------------------------------------:|
|             |           Grade          |                            --                            |            Standard constructor           |
|             |           Grade          | `double` elementarySchoolGrade, `double` highSchoolGrade | Constructor with initialization arguments |
|   `double`  | getElementarySchoolGrade |                            --                            |                                           |
|    `void`   | setElementarySchoolGrade |              `double` elementarySchoolGrade              |                                           |
|   `double`  |    getHighSchoolGrade    |                            --                            |                                           |
|    `void`   |    setHighSchoolGrade    |                 `double` highSchoolGrade                 |                                           |
|   `State`   |       getStateGrade      |                            --                            |                                           |
|    `void`   |       setStateGrade      |                    `State` stateGrade                    |                                           |
|    `int`    |       getGradeYear       |                            --                            |                                           |
|    `void`   |       setGradeYear       |                      `int` gradeYear                     |                                           |
