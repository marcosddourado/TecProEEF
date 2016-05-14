# State.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package com.mdsgpp.eef.model

## class State

#### Private members:

| Type      | Variable                       | Description |
|-----------|--------------------------------|-------------|
| `String`  | stateName                      |             |
| `String`  | stateAbbreviation              |             |
| `double`  | percentageCollaborationWithPIB |             |
| `int`     | statePopulation                |             |
| `Census`  | census                         |             |
| `Ideb`    | idebs                          |             |
| `Grade`   | studentGradesPerClass          |             |
| `Grade`   | gradeClassHours                |             |
| `Project` | scienceAndThecnologyProjects   |             |
| `Project` | primeirosProjetos                  |             |
| `Project` | inctProject                    |             |
| `Project` | apoioCnpqProject               |             |
| `Project` | jovensPesquisadoresProject     |             |
| `Grade`   | ageGradeDistortionRate         |             |
| `Grade`   | educationalAchievementRate     |             |
| `Grade`   | schoolDropoutRate              |             |

#### Public members:

| Return Type |            Method Name            |                                              Arguments                                             |                                  Description                                 |
|:-----------:|:---------------------------------:|:--------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------:|
|             |               State               |                                                 --                                                 |                             Standard constructor                             |
|             |               State               | `String` stateName, `String` stateAbbreviation, `HashMap<String, ArrayList<String[]>>` information |                    Constructor with initializer arguments                    |
|  `Census[]` |             getCensus             |                                                 --                                                 |                                                                              |
|    `void`   |             setCensus             |                         `HashMap<String, ArrayList<String[]>>` information                         |                                                                              |
|  `double[]` | getPercentageCollaborationWithPIB |                                                 --                                                 |                                                                              |
|    `void`   | setPercentageCollaborationWithPIB |                         `HashMap<String, ArrayList<String[]>>` information                         |                                                                              |
|    `int`    |         getStatePopulation        |                                                 --                                                 |                                                                              |
|    `void`   |         setStatePopulation        |                         `HashMap<String, ArrayList<String[]>>` information                         |                                                                              |
|   `Ideb[]`  |              getIdebs             |                                                 --                                                 |                                                                              |
|    `void`   |              setIdebs             |                         `HashMap<String, ArrayList<String[]>>` information                         |                                                                              |
|  `Grade[]`  |          returnEmptyGrade         |                                                 --                                                 |                                                                              |
|  `Grade[]`  |              setGrade             |          `HashMap<String, ArrayList<String[]>>` information, `String[]` namesOfIndicative          |                                                                              |
|  `Grade[]`  |      getStudentGradesPerClass     |                                                 --                                                 |                                                                              |
|    `void`   |      setStudentGradesPerClass     |          `HashMap<String, ArrayList<String[]>>` information, `String[]` namesOfIndicative          |                                                                              |
|  `Grade[]`  |         getGradeClassHours        |                                                 --                                                 |                                                                              |
|    `void`   |         setGradeClassHours        |          `HashMap<String, ArrayList<String[]>>` information, `String[]` namesOfIndicative          |                                                                              |
|  `Grade[]`  |     getAgeGradeDistortionRate     |                                                 --                                                 |                                                                              |
|    `void`   |     setAgeGradeDistortionRate     |          `HashMap<String, ArrayList<String[]>>` information, `String[]` namesOfIndicative          |                                                                              |
|   `String`  |            getStateName           |                                                 --                                                 |                                                                              |
|    `void`   |            setStateName           |                                         `String` stateName                                         |                                                                              |
|   `String`  |        getStateAbbreviation       |                                                 --                                                 |                                                                              |
|    `void`   |        setStateAbbreviation       |                                     `String` stateAbbreviation                                     |                                                                              |
| `Project[]` |         returnEmptyProject        |                                                 --                                                 |                                                                              |
| `Project[]` |            setProjects            |          `HashMap<String, ArrayList<String[]>>` information, `String[]` namesOfIndicative          |                                                                              |
| `Project[]` |  getScienceAndThecnologyProjects  |                                                 --                                                 |                                                                              |
|    `void`   |  setScienceAndThecnologyProjects  |          `HashMap<String, ArrayList<String[]>>` information, `String[]` namesOfIndicative          |                                                                              |
| `Project[]` |          getFirstProjects         |                                                 --                                                 |                                                                              |
|    `void`   |          setFirstProjects         |          `HashMap<String, ArrayList<String[]>>` information, `String[]` namesOfIndicative          |                                                                              |
| `Project[]` |          getProjectsInct          |                                                 --                                                 |                                                                              |
|    `void`   |          setProjectsInct          |          `HashMap<String, ArrayList<String[]>>` information, `String[]` namesOfIndicative          |                                                                              |
|  `Project`  |        getApoioCnpqProject        |                                                 --                                                 |                                                                              |
|    `void`   |        setApoioCnpqProject        |          `HashMap<String, ArrayList<String[]>>` information, `String[]` namesOfIndicative          |                                                                              |
| `Project[]` |   getJovensPesquisadoresProject   |                                                 --                                                 |                                                                              |
|    `void`   |   setJovensPesquisadoresProject   |          `HashMap<String, ArrayList<String[]>>` information, `String[]` namesOfIndicative          |                                                                              |
|  `Grade[]`  |   getEducationalAchievementRate   |                                                 --                                                 |                                                                              |
|    `void`   |   setEducationalAchievementRate   |          `HashMap<String, ArrayList<String[]>>` information, `String[]` namesOfIndicative          |                                                                              |
|   `Grade`   |        getSchoolDropoutRate       |                                                 --                                                 |                                                                              |
|    `void`   |        setSchoolDropoutRate       |          `HashMap<String, ArrayList<String[]>>` information, `String[]` namesOfIndicative          |                                                                              |
|    `void`   |              fillData             |                         `HashMap<String, ArrayList<String[]>>` information                         | Fill the object variables with argument 'information' and predetermined data |

#### Local Variables per Function:

|                                      |     Constructor     |                                                                  |
|:------------------------------------:|:-------------------:|:----------------------------------------------------------------:|
|                 Type                 |       Variable      |                            Description                           |
|               `String`               |     `stateName`     |     Provides a value to be set on private member `stateName`     |
|               `String`               | `stateAbbreviation` | Provides a value to be set on private member `stateAbbreviation` |
| `HashMap<String, ArrayList<String>>` |    `information`    |   Contains associated data to be set on several private members  |

|                       |        setCensus        |                                                               |
|:---------------------:|:-----------------------:|:-------------------------------------------------------------:|
|          Type         |         Variable        |                          Description                          |
| `ArrayList<String[]>` |  `elementaryFinalData`  |         Contains associated data to fill Census fields        |
| `ArrayList<String[]>` | `elementaryInitialData` |         Contains associated data to fill Census fields        |
| `ArrayList<String[]>` |     `highSchoolData`    |         Contains associated data to fill Census fields        |
| `ArrayList<String[]>` |   `ejaHighSchoolData`   |         Contains associated data to fill Census fields        |
| `ArrayList<String[]>` |   `ejaElementaryData`   |         Contains associated data to fill Census fields        |
|       `Census[]`      |         `census`        | Contains associated data to be set on private member `census` |

|            | getPercentageCollaborationWithPIB |                           |
|:----------:|:---------------------------------:|:-------------------------:|
|    Type    |              Variable             |        Description        |
| `double[]` |              `empty`              | Zero value |

|                                        |  setPercentageCollaborationWithPIB |                                                                           |
|:--------------------------------------:|:----------------------------------:|:-------------------------------------------------------------------------:|
|                  Type                  |              Variable              |                                Description                                |
| `HashMap<String, ArrayList<String[]>>` |            `information`           |        Contains associated data that include PIB collaboration data       |
|                `double`                | `percentageCollaborationWithPIB[]` | Contain data to be set on private member `percentageCollaborationWithPIB` |
|          `ArrayList<String[]>`         |               `data`               |            Contain associated data retrieved from `information`           |

|                                      | setStatePopulation |                                                             |
|:------------------------------------:|:------------------:|:-----------------------------------------------------------:|
|                 Type                 |      Variable      |                         Description                         |
| HashMap<String, ArrayList<String[]>> |     information    |    Contains associated data that include population data    |
|         `ArrayList<String[]>`        |       `data`       | Contains data to be set on private member `statePopulation` |

|          | getIdebs |             |
|:--------:|:--------:|:-----------:|
|   Type   | Variable | Description |
| `Ideb[]` |   empty  |  Zero value |

|                                        |         setIdebs        |                                                                     |
|:--------------------------------------:|:-----------------------:|:-------------------------------------------------------------------:|
|                  Type                  |         Variable        |                             Description                             |
| `HashMap<String, ArrayList<String[]>>` |      `information`      |           Contains associated data that include IDEB data           |
|          `ArrayList<String[]>`         |  `elementaryFinalData`  | Contain associated data retrieved from `information` to fill `ideb` |
|          `ArrayList<String[]>`         | `elementaryInitialData` | Contain associated data retrieved from `information` to fill `ideb` |
|          `ArrayList<String[]>`         |     `highSchoolData`    | Contain associated data retrieved from `information` to fill `ideb` |
|                `Ideb[]`                |          `ideb`         |           Contain data to be set on private member `idebs`          |

|           | returnEmptyGrade |             |
|:---------:|:----------------:|:-----------:|
|    Type   |     Variable     | Description |
| `Grade[]` |    emptyGrade    |  Zero value |

|                                        |       setGrade      |                                                                                                       |
|:--------------------------------------:|:-------------------:|:-----------------------------------------------------------------------------------------------------:|
|                  Type                  |       Variable      |                                              Description                                              |
| `HashMap<String, ArrayList<String[]>>` |    `information`    |                            Contains associated data that include Grade data                           |
|               `String[]`               | `namesOfIndicative` | Reference the correct data to be retrieved from `information`to `elementaryData` and `highSchoolData` |
|          `ArrayList<String[]>`         |   `elementaryData`  |                Contain associated data retrieved from `information` to fill `readGrade`               |
|          `ArrayList<String[]>`         |   `highSchoolData`  |                Contain associated data retrieved from `information` to fill `readGrade`               |
|                `Grade[]`               |     `readGrade`     |                                  Contain associated data about Grade                                  |


|                                        | setStudentGradesPerClass |                                                                    |
|:--------------------------------------:|:------------------------:|:------------------------------------------------------------------:|
|                  Type                  |         Variable         |                             Description                            |
| `HashMap<String, ArrayList<String[]>>` |        information       | Contains associated data that includes students/class per grade data |
|               `String[]`               |     namesOfIndicative    |    Reference the correct data to be retrieved from `information`   |

|                                        | setGradeClassHours |                                                               |
|:--------------------------------------:|:------------------:|:-------------------------------------------------------------:|
|                  Type                  |      Variable      |                          Description                          |
| `HashMap<String, ArrayList<String[]>>` |     information    |  Contains associated data that includes hours/class per grade  data |
|               `String[]`               |  namesOfIndicative | Reference the correct data to be retrieved from `information` |

|                                        | setAgeGradeDistortionRate |                                                                           |
|:--------------------------------------:|:-------------------------:|:-------------------------------------------------------------------------:|
|                  Type                  |          Variable         |                                Description                                |
| `HashMap<String, ArrayList<String[]>>` |        information        | Contains associated data that includes distortion rate/age per grade data |
|               `String[]`               |     namesOfIndicative     |       Reference the correct data to be retrieved from `information`       |

|          | setStateName |                                                       |
|:--------:|:------------:|:-----------------------------------------------------:|
|   Type   |   Variable   |                      Description                      |
| `String` |   stateName  | Contains data to be set on private member `stateName` |

|          | setStateAbbreviation |                                                               |
|:--------:|:--------------------:|:-------------------------------------------------------------:|
|   Type   |       Variable       |                          Description                          |
| `String` |   stateAbbreviation  | Contains data to be set on private member `stateAbbreviation` |

|             | returnEmptyProject |             |
|:-----------:|:------------------:|:-----------:|
|     Type    |      Variable      | Description |
| `Project[]` |        empty       |  Zero value |

|                                        |      setProjects     |                                                                                                               |
|:--------------------------------------:|:--------------------:|:-------------------------------------------------------------------------------------------------------------:|
|                  Type                  |       Variable       |                                                  Description                                                  |
| `HashMap<String, ArrayList<String[]>>` |     `information`    |                               Contains associated data that include Project data                              |
|               `String[]`               |  `namesOfIndicative` | Reference the correct data to be retrieved from `information`to `investedValuesData` and `projectsAmountData` |
|          `ArrayList<String[]>`         | `investedValuesData` |                  Contain associated data retrieved from `information` to fill `readProjects`                  |
|          `ArrayList<String[]>`         | `projectsAmountData` |                  Contain associated data retrieved from `information` to fill `readProjects`                  |
|               `Project[]`              |    `readProjects`    |                                     Contain associated data about projects                                    |


|                                        | setScienceAndThecnologyProjects |                                                                 |
|:--------------------------------------:|:--------------------:|:---------------------------------------------------------------:|
|                  Type                  |       Variable       |                           Description                           |
| `HashMap<String, ArrayList<Strnig[]>>` |      information     | Contains associated data that includes state abbreviations data |
|               `String[]`               |   namesOfIndicative  |  Reference the correct data to be retrieved from `information`  |

|                                        | setPrimeirosProjetos |                                                                        |
|:--------------------------------------:|:--------------------:|:----------------------------------------------------------------------:|
|                  Type                  |       Variable       |                               Description                              |
| `HashMap<String, ArrayList<Strnig[]>>` |      information     | Contains associated data that includes Primeiros Projetos project data |
|               `String[]`               |   namesOfIndicative  |      Reference the correct data to be retrieved from `information`     |

|                                        |  setProjectsInct  |                                                               |
|:--------------------------------------:|:-----------------:|:-------------------------------------------------------------:|
|                  Type                  |      Variable     |                          Description                          |
| `HashMap<String, ArrayList<Strnig[]>>` |    information    |    Contains associated data that includes INCT project data   |
|               `String[]`               | namesOfIndicative | Reference the correct data to be retrieved from `information` |

|                                        | setApoioCnpqProject |                                                                |
|:--------------------------------------:|:-------------------:|:--------------------------------------------------------------:|
|                  Type                  |       Variable      |                           Description                          |
| `HashMap<String, ArrayList<Strnig[]>>` |     information     | Contains associated data that includes Apoio CNPQ project data |
|               `String[]`               |  namesOfIndicative  |  Reference the correct data to be retrieved from `information` |

|                                        | setJovensPesquisadoresProject |                                                                          |
|:--------------------------------------:|:-----------------------------:|:------------------------------------------------------------------------:|
|                  Type                  |            Variable           |                                Description                               |
| `HashMap<String, ArrayList<Strnig[]>>` |          information          | Contains associated data that includes Jovens Pesquisadores project data |
|               `String[]`               |       namesOfIndicative       |       Reference the correct data to be retrieved from `information`      |

|                                        | setEducationalAchievementRate |                                                                          |
|:--------------------------------------:|:-----------------------------:|:------------------------------------------------------------------------:|
|                  Type                  |            Variable           |                                Description                               |
| `HashMap<String, ArrayList<Strnig[]>>` |          information          | Contains associated data that includes educational achievement rate data |
|               `String[]`               |       namesOfIndicative       |       Reference the correct data to be retrieved from `information`      |

|                                        | setSchoolDropoutRate |                                                                  |
|:--------------------------------------:|:--------------------:|:----------------------------------------------------------------:|
|                  Type                  |       Variable       |                            Description                           |
| `HashMap<String, ArrayList<Strnig[]>>` |      information     | Contains associated data that includes school dropout rates data |
|               `String[]`               |   namesOfIndicative  |   Reference the correct data to be retrieved from `information`  |

|                                      |                  fillData                 |                                                               |
|:------------------------------------:|:-----------------------------------------:|:-------------------------------------------------------------:|
|                 Type                 |                  Variable                 |                          Description                          |
| HashMap<String, ArrayList<String[]>> |                information                |               Contains associated data for State              |
|              `String[]`              |        `gradeClassHoursIndicatives`       | Contains data that can be stored and/or managed by the object |
|              `String[]`              |     `studentGradesPerClassIndicatives`    | Contains data that can be stored and/or managed by the object |
|              `String[]`              | `scienceAndThecnologyProjectsIndicatives` | Contains data that can be stored and/or managed by the object |
|              `String[]`              |       `primeirosProjetosIndicatives`      | Contains data that can be stored and/or managed by the object |
|              `String[]`              |       `apoioCnpqProjectIndicatives`       | Contains data that can be stored and/or managed by the object |
|              `String[]`              |  `jovensPesquisadoresProjectIndicatives`  |  Containsdata that can be stored and/or managed by the object |
|              `String[]`              |         `inctProjectsIndicatives`         | Contains data that can be stored and/or managed by the object |
|              `String[]`              |          `ageGradeDistortionRate`         | Contains data that can be stored and/or managed by the object |
|              `String[]`              |        `educationalAchievementRate`       | Contains data that can be stored and/or managed by the object |
|              `String[]`              |            `schoolDropoutRate`            | Contains data that can be stored and/or managed by the object |
