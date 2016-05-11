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

#### Local Variables per Function:

|          |   Constructor   |                                                              |
|:--------:|:---------------:|:------------------------------------------------------------:|
|   Type   |     Variable    |                          Description                         |
| `double` |   `elementary`  |   Provides a value to be set on private member `elementary`  |
| `double` | `highSchool`    | Provides a value to be set on private member `highSchool`    |
| `double` | `initialGrades` | Provides a value to be set on private member `initialGrades` |

|          | setElementary |                                                           |
|:--------:|:-------------:|:---------------------------------------------------------:|
|   Type   |    Variable   |                        Description                        |
| `double` |  `elementary` | Provides a value to be set on private member `elementary` |

|          | setHighSchool |                                                           |
|:--------:|:-------------:|:---------------------------------------------------------:|
|   Type   |    Variable   |                        Description                        |
| `double` |  `highSchool` | Provides a value to be set on private member `highSchool` |

|          | setInitialGrades |                                                              |
|:--------:|:----------------:|:------------------------------------------------------------:|
|   Type   |     Variable     |                          Description                         |
| `double` |  `initialGrades` | Provides a value to be set on private member `initialGrades` |

|         |   setState  |                                                          |
|:-------:|:-----------:|:--------------------------------------------------------:|
|   Type  |   Variable  |                        Description                       |
| `State` | `idebState` | Provides a value to be set on private member `idebState` |

|       | setIdebYear |                                                         |
|:-----:|:-----------:|:-------------------------------------------------------:|
|  Type |   Variable  |                       Description                       |
| `int` |  `idebYear` | Provides a value to be set on private member `idebYear` |
