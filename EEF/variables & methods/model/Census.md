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
| `double` |    `initialElementaryYears`   | Provides a value to be set on private member `initialElementaryYears`|
| `double` | `double finalElementaryYears` |  Provides a value to be set on private member `finalElementaryYears` |
| `double` |          `highSchool`         |       Provides a value to be set on private member `highSchool`|
| `double` |        `elementaryEJA`        |      Provides a value to be set on private member `elementaryEJA`|
| `double` |        `highSchoolEJA`        |      Provides a value to be set on private member `highSchoolEJA`|

|          | setInitialElementaryYears |                                                   |
|:--------:|:-------------------------:|:-------------------------------------------------:|
|   Type   |          Variable         |                    Description                    |
| `double` |  `initialElementaryYears` | Provides a value to be set on private member `initialElementaryYears`|

|          | setFinalElementaryYears |                                                 |
|:--------:|:-----------------------:|:-----------------------------------------------:|
|   Type   |         Variable        |                   Description                   |
| `double` |    `elementaryYears`    | Provides a value to be set on private member `finalElementaryYears` |

|          | setHighSchool |                                       |
|:--------:|:-------------:|:-------------------------------------:|
|   Type   |    Variable   |              Description              |
| `double` |  `highSchool` | Provides a value to be set on private member `highSchool` |

|          | setElementaryEJA |                                          |
|:--------:|:----------------:|:----------------------------------------:|
|   Type   |     Variable     |                Description               |
| `double` |  `elementaryEJA` | Provides a value to be set on private member `elementaryEJA`|

|          | setHighSchoolEJA |                                                              |
|:--------:|:----------------:|:------------------------------------------------------------:|
|   Type   |     Variable     |                          Description                         |
| `double` |  `highSchoolEJA` | Provides a value to be set on private member `highSchoolEJA` |

|          | setCensusState |                                                            |
|:--------:|:--------------:|:----------------------------------------------------------:|
|   Type   |    Variable    |                         Description                        |
| `double` |  `censusState` | Provides a value to be set on private member `censusState` |

|          | setCensusYear |                                                           |
|:--------:|:-------------:|:---------------------------------------------------------:|
|   Type   |    Variable   |                        Description                        |
| `double` |  `censusYear` | Provides a value to be set on private member `censusYear` |
