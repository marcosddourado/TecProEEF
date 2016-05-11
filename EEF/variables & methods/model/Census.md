# Census.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package com.mdsgpp.eef.model

## class Census

#### Private members:

| Type     | Variable                     | Description|
|----------|------------------------------|------------|
| `double` | initialElementaryYears |            |
| `double` | finalElementaryYears   |            |
| `double` | highSchool                   |            |
| `double` | elementaryEJA          |            |
| `double` | highSchoolEJA                |            |
| `int`    | censusYear                   |Contain the year when census were originated            |
| `State`  | censusState                  |Contain the state where census is from|

#### Public members:

| Return Type |           Method Name           |                                                                        Arguments                                                                        |                Description                |
|:-----------:|:-------------------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------:|
|             |              Census             |                                                                            --                                                                           |            Standard constructor           |
|             |              Census             | `double` initialElementaryYears, `double` finalElementaryYears, `double` highSchool,  `double` elementaryEJA,  `double` highSchoolEJA | Constructor with initialization arguments |
|   `double`  | getInitialElementaryYears |                                                                            --                                                                           |                                           |
|    `void`   | setInitialElementaryYears |                                                          `double` initialElementaryYears                                                          |                                           |
|   `double`  |  getFinalElementaryYears  |                                                                            --                                                                           |                                           |
|    `void`   |  setFinalElementaryYears  |                                                           `double final` ElementaryYears                                                          |                                           |
|   `double`  |          getHighSchool          |                                                                            --                                                                           |                                           |
|    `void`   |          setHighSchool          |                                                                   `double` highSchool                                                                   |                                           |
|   `double`  |      getElementaryEJA     |                                                                            --                                                                           |                                           |
|    `void`   |      setElementaryEJA     |                                                               `double` elementaryEJA                                                              |                                           |
|   `double`  |         getHighSchoolEJA        |                                                                            --                                                                           |                                           |
|    `void`   |         getHighSchoolEJA        |                                                                  `double` highSchoolEJA                                                                 |                                           |
|   `State`   |          getCensusState         |                                                                            --                                                                           |                                           |
|    `void`   |          setCensusState         |                                                                   `State` censusState                                                                   |                                           |
|    `int`    |          getCensusYear          |                                                                            --                                                                           |                                           |
|    `void`   |          setCensusYear          |                                                                     `int` censusYear                                                                    |                                           |

#### Local Variables per Function:

|          |          Constructor          |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `Double` |    `initialElementaryYears`   | Provides a value to be set on private member `initialElementaryYears`|
| `Double` | `double finalElementaryYears` |  Provides a value to be set on private member `finalElementaryYears` |
| `Double` |          `highSchool`         |       Provides a value to be set on private member `highSchool`|
| `Double` |        `elementaryEJA`        |      Provides a value to be set on private member `elementaryEJA`|
| `Double` |        `highSchoolEJA`        |      Provides a value to be set on private member `highSchoolEJA`|

|          | setInitialElementaryYears |                                                   |
|:--------:|:-------------------------:|:-------------------------------------------------:|
|   Type   |          Variable         |                    Description                    |
| `Double` |  `initialElementaryYears` | Provides a value to be set on private member `initialElementaryYears`|

|          | setFinalElementaryYears |                                                 |
|:--------:|:-----------------------:|:-----------------------------------------------:|
|   Type   |         Variable        |                   Description                   |
| `Double` |    `elementaryYears`    | Provides a value to be set on private member `finalElementaryYears` |

|          | setHighSchool |                                       |
|:--------:|:-------------:|:-------------------------------------:|
|   Type   |    Variable   |              Description              |
| `Double` |  `highSchool` | Provides a value to be set on private member `highSchool` |

|          | setElementaryEJA |                                          |
|:--------:|:----------------:|:----------------------------------------:|
|   Type   |     Variable     |                Description               |
| `Double` |  `elementaryEJA` | Provides a value to be set on private member `elementaryEJA`|

|          | setHighSchoolEJA |                                                              |
|:--------:|:----------------:|:------------------------------------------------------------:|
|   Type   |     Variable     |                          Description                         |
| `Double` |  `highSchoolEJA` | Provides a value to be set on private member `highSchoolEJA` |

|          | setCensusState |                                                            |
|:--------:|:--------------:|:----------------------------------------------------------:|
|   Type   |    Variable    |                         Description                        |
| `Double` |  `censusState` | Provides a value to be set on private member `censusState` |

|          | setCensusYear |                                                           |
|:--------:|:-------------:|:---------------------------------------------------------:|
|   Type   |    Variable   |                        Description                        |
| `Double` |  `censusYear` | Provides a value to be set on private member `censusYear` |
