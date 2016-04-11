# Census.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package com.mdsgpp.eef.model

## class Census

#### Private members:

| Type     | Variable                     | Description|
|----------|------------------------------|------------|
| `double` | initialElementarySchoolYears |            |
| `double` | finalElementarySchoolYears   |            |
| `double` | highSchool                   |            |
| `double` | elementarySchoolEJA          |            |
| `double` | highSchoolEJA                |            |
| `int`    | censusYear                   |            |
| `State`  | censusState                  |            |

#### Public members:

| Return Type |           Method Name           |                                                                        Arguments                                                                        |                Description                |
|:-----------:|:-------------------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------:|
|             |              Census             |                                                                            --                                                                           |            Standard constructor           |
|             |              Census             | `double` initialElementarySchoolYears, `double` finalElementarySchoolYears, `double` highSchool,  `double` elementarySchoolEJA,  `double` highSchoolEJA | Constructor with initialization arguments |
|   `double`  | getInitialElementarySchoolYears |                                                                            --                                                                           |                                           |
|    `void`   | setInitialElementarySchoolYears |                                                          `double` initialElementarySchoolYears                                                          |                                           |
|   `double`  |  getFinalElementarySchoolYears  |                                                                            --                                                                           |                                           |
|    `void`   |  setFinalElementarySchoolYears  |                                                           `double final` ElementarySchoolYears                                                          |                                           |
|   `double`  |          getHighSchool          |                                                                            --                                                                           |                                           |
|    `void`   |          setHighSchool          |                                                                   `double` highSchool                                                                   |                                           |
|   `double`  |      getElementarySchoolEJA     |                                                                            --                                                                           |                                           |
|    `void`   |      setElementarySchoolEJA     |                                                               `double` elementarySchoolEJA                                                              |                                           |
|   `double`  |         getHighSchoolEJA        |                                                                            --                                                                           |                                           |
|    `void`   |         getHighSchoolEJA        |                                                                  `double` highSchoolEJA                                                                 |                                           |
|   `State`   |          getCensusState         |                                                                            --                                                                           |                                           |
|    `void`   |          setCensusState         |                                                                   `State` censusState                                                                   |                                           |
|    `int`    |          getCensusYear          |                                                                            --                                                                           |                                           |
|    `void`   |          setCensusYear          |                                                                     `int` censusYear                                                                    |                                           |
