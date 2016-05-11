# Ideb.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package com.mdsgpp.eef.model

## class Ideb

#### Private members:

| Type     | Variable         |               Description                |
|----------|------------------|------------------------------------------|
| `double` | elementary |Contais the Ideb's average of the state's elementary schools |
| `double` | highSchool       |Contais the Ideb's average of the state's high schools |
| `double` | initialGrades    |Contais the Ideb's average of the state's initial schools |
| `State`  | idebState        |Contais the Ideb's average of the state's schools |
| `int`    | idebYear         |Represents the year that was realized the averages |

#### Public members:

| Return Type |     Method Name     |         Arguments         |                Description                |
|:-----------:|:-------------------:|:-------------------------:|:-----------------------------------------:|
|             |         Ideb        |             --            |            Standard constructor           |
|             |         Ideb        |             --            | Constructor with initialization arguments |
|   `double`  | getElementary |             --            |          |
|    `void`   | setElementary | `double` elementary |                                           |
|   `double`  |    getHighSchool    |             --            |                                           |
|    `void`   |    setHighSchool    |    `double` highSchool    |                                           |
|   `double`  |   getInitialGrades  |             --            |                                           |
|    `void`   |   setInitialGrades  |   `double` initialGrades  |                                           |
|   `State`   |       getState      |             --            |                                           |
|    `void`   |       setState      |     `State` idebState     |                                           |
|    `int`    |     getIdebYear     |             --            |                                           |
|    `void`   |     setIdebYear     |       `int` idebYear      |                                           |
