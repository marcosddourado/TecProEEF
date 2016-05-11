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
| `Double` |    `initialElementaryYears`   | Set private member `initialElementaryYears` value |
| `Double` | `double finalElementaryYears` |  Set private member `finalElementaryYears` value  |
| `Double` |          `highSchool`         |       Set private member `highSchool` value       |
| `Double` |        `elementaryEJA`        |      Set private member `elementaryEJA` value     |
| `Double` |        `highSchoolEJA`        |      Set private member `highSchoolEJA` value     |
