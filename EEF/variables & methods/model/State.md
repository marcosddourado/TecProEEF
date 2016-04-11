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
| `Project` | firstProjects                  |             |
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
