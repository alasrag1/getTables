package javafxapplication6;

import com.sun.javafx.geom.AreaOp;
import java.util.ArrayList;
import java.util.zip.Checksum;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

class sectionTime {

    int day = -1;
    int start = -1;
    int end = -1;
    String type = "-1";
    int NumberOfKinds = -1; //kinds is {lec , sec , lab}
    String name = "";
    int ClassName = -1; //kinds is {lec , sec , lab}
    String ClassNames = "";
    String textContent = "";

}

class SubjectSection {

    sectionTime lec = new sectionTime();
    sectionTime sec = new sectionTime();
    sectionTime lab = new sectionTime();
}

public class JavaFXApplication6 extends Application {

    String[] week = {"sat", "sun", "mon", "tue", "wed", "thu", "fri"};
    sectionTime[][] check;
    SubjectSection[][] arr;
    String[] name;
    int count_ = 0;
    int c = 0;
    int nm = 0;
    int nm2 = 0;
    int nm3 = 0;
    int nm4 = 0;
    String[] ClassesNames = new String[21];

    String increaseCharacter(String s, int n) {
        for (int i = s.length(); i < n; i++) {
            s += " ";
        }
        return s;
    }

    void print(sectionTime[][] check) {

        for (int i = 0; i < check.length; i++) {
            System.out.print(week[i] + " : ");
            for (int j = 0; j < check[0].length; j++) {
                String compare = "-1";
                int numOfChar = 20;
                if (!check[i][j].type.equals(compare)) {

                    System.out.print(check[i][j].name
                            + "->" + check[i][j].type + "->"
                            + increaseCharacter(check[i][j].ClassNames, numOfChar)
                            + "//        ");
                } else {
                    System.out.printf("     " + "->" + "   " + "->" + increaseCharacter("", numOfChar) + "//        ");

                }
            }
            System.out.println("");
        }
//        String s = "";
//        for (int i = 0; i < check.length; i++) {
//            for (int j = 0; j < check[0].length; j++) {
//                if (!s.contains(check[i][j].name)) {
//                    s += check[i][j].name;
//                    String[] classes = check[i][j].ClassNames.split(",");
//                    System.out.print(check[i][j].name + " :  ");
//                    for (int k = 0; k < classes.length; k++) {
//                        System.out.print(ClassesNames[Integer.parseInt(classes[k])] + ",,,");
//                    }
//                    System.out.println("");
//
//                }
//            }
//        }
        System.out.println("");
        System.out.println("");
    }

    boolean subjectFounded(int day) {
        if (day == -1) {
            return false;
        } else {
            return true;
        }
    }

    void printWithNoGaps(sectionTime[][] check, int numOfGaps, int minNumOfSubjectInDay, int maxNumOfSubjectIn8hour, int maxNumOfSubjectIn4oclock) {

        int flag = 0;
        count_ = 0;
        int gap = 0;
        for (int k = 0; k < check.length; k++) {
            flag = 0;
            int gapsNum = 0;
            for (int l = 0; l < check[0].length; l++) {
                if (flag == 0 && subjectFounded(check[k][l].day)) {
                    flag = 1;
                } else if (flag == 1 && !subjectFounded(check[k][l].day)) {
                    flag = 2;
                    gapsNum = 1;
                } else if (flag == 2 && !subjectFounded(check[k][l].day)) {
                    gapsNum++;
                } else if (flag == 2 && subjectFounded(check[k][l].day)) {
                    flag = 1;
                    gap += gapsNum;
                    gapsNum = 0;
                }

            }
            if (gap > numOfGaps) {
                return;
            }
        }

        for (int i = 0; i < check.length; i++) {
            int oneSubjectInDay = 0;
            for (int j = 0; j < check[0].length; j++) {
                if (check[i][j].day != -1) {
                    oneSubjectInDay++;
                }
            }
            if (oneSubjectInDay < minNumOfSubjectInDay && oneSubjectInDay != 0) {
                return;
            }
        }

        int maxNumOfSubjectIn8hour_ = 0;
        for (int i = 0; i < check.length; i++) {

            if (check[i][0].day != -1) {
                maxNumOfSubjectIn8hour_++;
            }
        }
        if (maxNumOfSubjectIn8hour_ > maxNumOfSubjectIn8hour) {
            return;
        }

        int maxNumOfSubjectIn4hour_ = 0;
        for (int i = 0; i < check.length; i++) {

            if (check[i][4].day != -1) {
                maxNumOfSubjectIn4hour_++;
            }
        }
        if (maxNumOfSubjectIn4hour_ > maxNumOfSubjectIn4oclock) {
            return;
        }

        String nameClone = "";
        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < check[0].length; j++) {
                if (check[i][j].day != -1 && !nameClone.contains(check[i][j].name)) {
                    nameClone += check[i][j].name;
                    count_++;
                }
            }
        }
        if (count_ != name.length) {
            return;
        }
//        int[] flag1 = new int[100];

//        for (int i = 0; i < check.length; i++) {
//            for (int j = 0; j < check[0].length; j++) {
//                if (check[i][j].name == "IT311") {
//                    flag1[0] = 1;
//                }
//                if (check[i][j].name == "CS322" && check[i][j].ClassNames.contains(CheckClassesNames("IS Min CS") + "")) {
//                    flag1[1] = 1;
//
//                }
//                if (check[i][j].name == "CS301" && (check[i][j].ClassNames.contains(CheckClassesNames("CS Min IS") + "") || check[i][j].ClassNames.contains(CheckClassesNames("CS Min SE") + ""))) {
//                    flag1[2] = 1;
//                }
//
//            }
//
//        }
//        int sum = 0;
//        for (int i = 0; i < flag1.length; i++) {
//            sum += flag1[i];
//        }
//
//        if (sum != 3) {
////            System.out.println(sum);
//            return;
//        }
        print(check);

    }

    boolean isCheckEmpty(sectionTime st) {
        if (st.day == -1) {
            return true;
        }
        if (check[st.day][st.end / 2 - 1].day == -1) {
            return true;
        } else {
            return false;
        }
    }

    int checkNumOfKinds(SubjectSection subject) {
        int count = 0;
        if (subject.lec.day != -1) {
            count++;
        }
        if (subject.sec.day != -1) {
            count++;
        }
        if (subject.lab.day != -1) {
            count++;
        }
        return count;

    }

    int CheckClassesNames(String s) {
        for (int i = 0; i < ClassesNames.length; i++) {
            if (ClassesNames[i].contains(s)) {
                return i;
            }
        }
        return 0;

    }

    void equal(sectionTime st) {
        if (st.day == -1) {
            return;
        }
        check[st.day][st.end / 2 - 1] = st;
    }

    void deleteAllRepeatedSubjects() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j].lec.ClassName != -1) {
                    arr[i][j].lec.ClassNames += arr[i][j].lec.ClassName;
                }
                if (arr[i][j].sec.ClassName != -1) {
                    arr[i][j].sec.ClassNames += arr[i][j].sec.ClassName;
                }
                if (arr[i][j].lab.ClassName != -1) {
                    arr[i][j].lab.ClassNames += arr[i][j].lab.ClassName;
                }
                for (int k = j + 1; k < arr[0].length; k++) {

                    if (arr[i][j].lec.day == arr[i][k].lec.day
                            && arr[i][j].lec.start == arr[i][k].lec.start
                            && arr[i][j].lec.end == arr[i][k].lec.end
                            && arr[i][j].lec.name == arr[i][k].lec.name) {
                        if (arr[i][j].sec.day == arr[i][k].sec.day
                                && arr[i][j].sec.start == arr[i][k].sec.start
                                && arr[i][j].sec.end == arr[i][k].sec.end
                                && arr[i][j].sec.name == arr[i][k].sec.name) {
                            if (arr[i][j].lab.day == arr[i][k].lab.day
                                    && arr[i][j].lab.start == arr[i][k].lab.start
                                    && arr[i][j].lab.end == arr[i][k].lab.end
                                    && arr[i][j].lab.name == arr[i][k].lab.name) {
//                                System.out.println(arr[i][j].hashCode());
                                arr[i][j].lec.ClassNames += "," + arr[i][k].lec.ClassName;
                                arr[i][j].sec.ClassNames += "," + arr[i][k].sec.ClassName;
                                arr[i][j].lab.ClassNames += "," + arr[i][k].lab.ClassName;

                                arr[i][k] = new SubjectSection();
                            }
                        }
                    }
                }
            }
        }

    }

    void deleteOneSubjects(int i, int j) {

        arr[i][j].lec.ClassName = -1;

        arr[i][j].sec.ClassName = -1;

        arr[i][j].lab.ClassName = -1;

    }

    void delete(sectionTime st) {
        if (st.day == -1) {
            return;
        }

        check[st.day][st.end / 2 - 1] = new sectionTime();
    }

    void createCheck(int i, int j) {
        check = new sectionTime[7][5];

        for (; i < check.length; i++) {
            for (; j < check[0].length; j++) {
                check[i][j] = new sectionTime();
                //                check[i][j] = null;
            }
        }
    }

    int CheckFlags(int[] flag, int typeNum) {

        for (int i = typeNum + 1; i < flag.length; i++) {
            if (flag[i] == 1) {
                return 1;
            };
        }
        return 0;
    }

    int[] CheckAllFlags(int m) {
        int[] flag = {0, 0, 0};
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[m][i].lec.day != -1) {
                flag[0] = 1;
            }
            if (arr[m][i].sec.day != -1) {
                flag[1] = 1;
            }
            if (arr[m][i].lab.day != -1) {
                flag[2] = 1;
            }
        }
        return flag;
    }
    //    m  = 0;

//    private void getTheTables(int m, int typeNum) {
//
////            if (m == 4) {
////                System.out.println(m);
////            }
////          (((T(N+4) + N + 3) + N + 2) + N + 1) + N 
////             T(N+i) + iN + i
////             log(N) = log(i)
////             T(N+i) + iN + i
////          T(N+4) + N + 3
////            
//        if (m == arr.length) {
//            printWithNoGaps(check, 0, 2, 2, 0);
//            return;
//        }
////            int Gaps = 10;
////           k int minNumOfSubjectInDay = 0;
////            int maxNumOfSubjectIn8hour = 81;
////            int maxNumOfSubjectIn4oclock = 81;
////            boolean deleteAllRepeatedSubjects = true;
////
//////
//////
////            if (deleteAllRepeatedSubjects && i == 0 && m == 0) {
////                deleteAllRepeatedSubjects();
////            }
//        sectionTime[] sub = new sectionTime[3];
//        int[] flag = {0, 0, 0};
//        int[] flagForAll = CheckAllFlags(m);
//        if (m <= 3) {
//            c = c;
//        }
//        if (flagForAll[typeNum] == 1) {
//            for (int i = 0; i < arr[0].length; i++) {
//                sub[0] = arr[m][i].lec;
//                sub[1] = arr[m][i].sec;
//                sub[2] = arr[m][i].lab;
//                for (int j = 0; j < sub.length; j++) {
//                    if (sub[j].day != -1) {
//                        flag[j] = 1;
//                    } else {
//                        flag[j] = 0;
//                    }
//                }
//                if (sub[typeNum].day != -1) {
//                    if (isCheckEmpty(sub[typeNum])) {
//                        equal(sub[typeNum]);
//                        if (CheckFlags(flagForAll, typeNum) == 1) {
//                            getTheTables(m, typeNum + 1);
//                        } else if (CheckFlags(flagForAll, typeNum) != 1) {
//                            getTheTables(m + 1, 0);
//                        }
//                        delete(sub[typeNum]);
//                    }
//                }
//                if (flagForAll[typeNum] == 1 && i == arr[0].length - 1) {
//                    return;
//                }
//            }
//        } else if (typeNum != 3) {
//            getTheTables(m, typeNum + 1);
////            T(n) + n 
//        } else if (typeNum == 3) {
//            getTheTables(m + 1, 0);
//        }
//    }

    
    private void getTheTables(int m, SubjectSection[][] arr) {
        for (int i = 0; i < arr[0].length; i++) {
            int isAvailable = 0;

            if (arr[m][i].lec.day != -1) {
                //                    n1 = (arr[m][n].lec.end) / 2;
                isAvailable++;
            }

            if (arr[m][i].sec.day != -1) {
                //                    n2 = (arr[m][n].sec.end) / 2;
                isAvailable++;
            }

            if (arr[m][i].lab.day != -1) {
                //                    n3 = (arr[m][n].lab.end) / 2;
                isAvailable++;
            }
            boolean type = false;
            int type2 = 0;
            int Gaps = 2;
            int minNumOfSubjectInDay = 2;
            int maxNumOfSubjectIn8hour = 81;
            int maxNumOfSubjectIn4oclock = 0;
            boolean deleteAllRepeatedSubjects = true;

//
//
            if (deleteAllRepeatedSubjects && i == 0 && m == 0) {
                deleteAllRepeatedSubjects();
            }
            if (isAvailable == 1) {
                if (arr[m][i].lec.day != -1) {
                    type = isCheckEmpty(arr[m][i].lec);
                    type2 = 1;
                } else if (arr[m][i].sec.day != -1) {
                    type = isCheckEmpty(arr[m][i].sec);
                    type2 = 2;
                } else {
                    type = isCheckEmpty(arr[m][i].lab);
                    type2 = 3;
                }

                if (type) {
                    if (arr[m][i].lec.day != -1) {
                        equal(arr[m][i].lec);
                    } else if (arr[m][i].sec.day != -1) {
                        equal(arr[m][i].sec);
                    } else {
                        equal(arr[m][i].lab);
                    }
                }
                if (m != arr.length - 1) {
                    getTheTables(m + 1, arr);

                } else {
                    printWithNoGaps(check, Gaps, minNumOfSubjectInDay, maxNumOfSubjectIn8hour, maxNumOfSubjectIn4oclock);
                    //                        print(check);

                }
                if (type) {
                    if (type2 == 1) {
                        delete(arr[m][i].lec);
                    } else if (type2 == 2) {

                        delete(arr[m][i].sec);
                    } else if (type2 == 3) {

                        delete(arr[m][i].lab);
                    }
                }
            } else if (isAvailable == 2 && arr[m][i].lec.day != -1) {
                if (isCheckEmpty(arr[m][i].lec) && isCheckEmpty(arr[m][i].sec)) {
                    equal(arr[m][i].lec);
                    equal(arr[m][i].sec);
                    if (m != arr.length - 1) {
                        getTheTables(m + 1, arr);

                    } else {

                        printWithNoGaps(check, Gaps, minNumOfSubjectInDay, maxNumOfSubjectIn8hour, maxNumOfSubjectIn4oclock);
                        //                        print(check);

                    }
                    delete(arr[m][i].lec);
                    delete(arr[m][i].sec);

                    //                 break;
                }
            } else if (isAvailable == 2 && arr[m][i].lec.day == -1) {
                if (isCheckEmpty(arr[m][i].sec) && isCheckEmpty(arr[m][i].lab)) {
                    equal(arr[m][i].sec);
                    equal(arr[m][i].lab);
                    if (m != arr.length - 1) {
                        getTheTables(m + 1, arr);

                    } else {

                        printWithNoGaps(check, Gaps, minNumOfSubjectInDay, maxNumOfSubjectIn8hour, maxNumOfSubjectIn4oclock);
                        //                        print(check);

                    }
                    delete(arr[m][i].sec);
                    delete(arr[m][i].lab);

                    //                 break;
                }
            } else if (isAvailable == 3) {
                if (isCheckEmpty(arr[m][i].lec) && isCheckEmpty(arr[m][i].sec) && isCheckEmpty(arr[m][i].lab)) {
                    equal(arr[m][i].lec);
                    equal(arr[m][i].sec);
                    equal(arr[m][i].lab);
                    if (m != arr.length - 1) {
                        getTheTables(m + 1, arr);

                    } else {
                        printWithNoGaps(check, Gaps, minNumOfSubjectInDay, maxNumOfSubjectIn8hour, maxNumOfSubjectIn4oclock);
                        //                        print(check);
                    }
                    delete(arr[m][i].lec);
                    delete(arr[m][i].sec);
                    delete(arr[m][i].lab);
                    //                    break;
                }
            }
        }

    }

    @Override
    public void start(Stage primaryStage) {
        name = new String[7];

        // ########################GET NAMES WITH JS ############################
        //          let name = document.querySelectorAll("#ctl00_ContentPlaceHolder1_grd_Group_Color tbody tr"); 
        //          let str= "";
        //            for(let i = 0 ; i < name.length;i++){
        //            str += `name[${i}] = "${name[i].lastElementChild.innerHTML.trim()}";`
        //            }
        //              console.log(str); 
        /////////////////////////////////////////////////////////////////////////////////////////
        //
        //
        //
        //
        //
        name[0] = "CS301"; // change name to the new courses code
        name[1] = "IS374";
        name[2] = "CS322";
        name[3] = "CS366";
        name[4] = "CS312";
        name[5] = "CS305";
        name[6] = "IT331"; // net

        arr = new SubjectSection[name.length][10];//[num of subjects] [ num of tables{a,b,c,d}].....
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = new SubjectSection();
            }
        }
        // ########################GET ARR WITH JS ############################
//var myArr = "";
//var myArrTextContent = "";
//var myNames = "";
//var theClass = 0;
//var stop = 0;
//function getArr() {
//  console.log("first");
//  let table = document.querySelectorAll(
//    "#ctl00_ContentPlaceHolder1_Schedule1 tbody"
//  );
//  let tr_td = document.querySelectorAll(
//    "#ctl00_ContentPlaceHolder1_Schedule1 tbody tr > *"
//  );
//
//  let tr = document.querySelectorAll(
//    "#ctl00_ContentPlaceHolder1_Schedule1 tbody tr"
//  );
//  let subject_td = [];
//  let string;
//  function found_subject_td(tr_td, text) {
//    for (let i = 0; i < tr_td.length; i++) {
//      if (tr_td[i].textContent.includes(text)) {
//        subject_td.push(tr_td[i]);
//      }
//    }
//  }
//
//  weekDays = [
//    "Saturday",
//    "Sunday",
//    "Monday",
//    "Tuesday",
//    "Wednesday",
//    "Thursday",
//    "Friday",
//  ];
//
//  function findDay(subject) {
//    for (let i = 0; i < names.length; i++) {
//      if (subject.parentElement.children[0].textContent.includes(weekDays[i]))
//        return i;
//    }
//  }
//  function findStart(subject) {
//    for (let j = 0; j < tr[0].children.length; j++) {
//      if (
//        subject.getBoundingClientRect().left ==
//        tr[0].children[j].getBoundingClientRect().left
//      ) {
//        return tr[0].children[j].textContent.trim();
//      }
//    }
//  }
//
//  function checkNumberOfKinds(subject) {
//    let count = 0;
//    tr_td = document.querySelectorAll(
//      "#ctl00_ContentPlaceHolder1_Schedule1 tbody tr > *"
//    );
//    for (let j = 0; j < tr_td.length; j++) {
//      let td = tr_td[j];
//
//      if (td.textContent.includes(getName(subject))) {
//        count++;
//      }
//    }
//    return count;
//  }
//  function checkKind(subject) {
//    if (subject.textContent.includes("Lect")) {
//      return "lec";
//    } else if (subject.textContent.includes("Sec")) {
//      return "sec";
//    } else if (subject.textContent.includes("Lab")) {
//      return "lab";
//    } else {
//      return "???";
//    }
//  }
//  // i = the subject
//  function getIInArr(subject) {
//    for (let i = 0; i < names.length; i++) {
//      if (subject.textContent.includes(names[i])) return i;
//    }
//  }
//
//  function getName(subject) {
//    for (let j = 0; j < names.length; j++) {
//      if (subject.textContent.includes(names[j])) return names[j];
//    }
//  }
//  function findTdWithType(subject_td, type, classCode) {
//    for (let i = 0; i < subject_td.length; i++) {
//      if (
//        subject_td[i].textContent.includes(classCode) &&
//        subject_td[i].textContent.includes(type)
//      ) {
//        return subject_td[i];
//      }
//    }
//    return null;
//  }
//
//  function getDetails(subject) {
//    if (subject != null) {
//      return `${subject.textContent} + ${findDay(subject)} + ${findStart(
//        subject
//      )}`;
//    } else {
//      return "not Founded";
//    }
//  }
//
//  let name = document.querySelectorAll(
//    "#ctl00_ContentPlaceHolder1_grd_Group_Color tbody tr"
//  );
//  let names = [];
//  names[0] = "CS301";
//  names[1] = "IS374";
//  names[2] = "CS322";
//  names[3] = "CS366";
//  names[4] = "CS312";
//  names[5] = "CS305";
//  // names[6] = "IT311"; // st
//  names[6] = "IT331"; // Net
//
//  for (let i = 0; i < names.length; i++) {
//    found_subject_td(tr_td, names[i]);
//  }
//  console.log(subject_td[0]);
//  if (subject_td[0] == null) {
//    return;
//  }
//  console.log(subject_td[0]);
//  // stop =0;
//  // while (stop != 10 ** 8) {
//  //   stop += 0.5;
//  // }
//
//  function AddToMyArr(subject) {
//    for (let i = 0; i < subject_td.length; i++) {
//      let subject = subject_td[i];
//      myArr += `arr[${getIInArr(subject)}][${theClass}].${checkKind(
//        subject
//      )}.day = ${findDay(subject)};`;
//      myArr += `arr[${getIInArr(subject)}][${theClass}].${checkKind(
//        subject
//      )}.start = ${findStart(subject)};`;
//      myArr += `arr[${getIInArr(subject)}][${theClass}].${checkKind(
//        subject
//      )}.end = ${+findStart(subject) + 1};`;
//      myArr += `arr[${getIInArr(subject)}][${theClass}].${checkKind(
//        subject
//      )}.type = "${checkKind(subject)}";`;
//      myArr += `arr[${getIInArr(subject)}][${theClass}].${checkKind(
//        subject
//      )}.NumberOfKinds = ${checkNumberOfKinds(subject)};`;
//      myArr += `arr[${getIInArr(subject)}][${theClass}].${checkKind(
//        subject
//      )}.name = "${getName(subject)}";`;
//      myArr += `arr[${getIInArr(subject)}][${theClass}].${checkKind(
//        subject
//      )}.ClassName = ${theClass};`;
//    }
//  }
//
//  function checkIFthetdReapeated() {
//    function AddToMyArr(subject) {
//      myArr += `arr[${getIInArr(subject)}][${theClass}].${checkKind(
//        subject
//      )}.day = ${findDay(subject)};`;
//      myArr += `arr[${getIInArr(subject)}][${theClass}].${checkKind(
//        subject
//      )}.start = ${findStart(subject)};`;
//      myArr += `arr[${getIInArr(subject)}][${theClass}].${checkKind(
//        subject
//      )}.end = ${+findStart(subject) + 1};`;
//      myArr += `arr[${getIInArr(subject)}][${theClass}].${checkKind(
//        subject
//      )}.type = "${checkKind(subject)}";`;
//      myArr += `arr[${getIInArr(subject)}][${theClass}].${checkKind(
//        subject
//      )}.NumberOfKinds = ${checkNumberOfKinds(subject)};`;
//      myArr += `arr[${getIInArr(subject)}][${theClass}].${checkKind(
//        subject
//      )}.name = "${getName(subject)}";`;
//      myArr += `arr[${getIInArr(subject)}][${theClass}].${checkKind(
//        subject
//      )}.ClassName = ${theClass};`;
//    }
//    let flagy = 0;
//    for (let i = 0; i < subject_td.length; i++) {
//      let subject = subject_td[i];
//      let lec = findTdWithType(subject_td, "Lect", getName(subject));
//      let sec = findTdWithType(subject_td, "Sec", getName(subject));
//      let lab = findTdWithType(subject_td, "Lab", getName(subject));
//
//      if (
//        !myArrTextContent.includes(
//          `,${getDetails(lec)},${getDetails(sec)},${getDetails(lab)},`
//        )
//      ) {
//        lec != null ? AddToMyArr(lec) : null;
//        sec != null ? AddToMyArr(sec) : null;
//        lab != null ? AddToMyArr(lab) : null;
//        myArrTextContent += `,${getDetails(lec)},${getDetails(
//          sec
//        )},${getDetails(lab)},`;
//        flagy = 1;
//      }
//    }
//    return flagy;
//  }
//
//  // AddToMyArr(subject_td);
//  if (checkIFthetdReapeated() == 0) {
//    return;
//  }
//  if (
//    typeof ele1 != "undefined" &&
//    typeof ele3 != "undefined" &&
//    ele1 != null &&
//    ele3 != null
//  ) {
//    myNames += `ClassesNames[${theClass}]="${
//      ele3.options[ele3.selectedIndex].text
//    }";`;
//  }
//  theClass++;
//  console.log("end");
//  return myArr;
//}
//
//let ele1 = document.getElementById("ctl00_ContentPlaceHolder1_ddl_Department");
//let ele2 = document.getElementById("ctl00_ContentPlaceHolder1_ddl_Period");
//let ele3 = document.getElementById("ctl00_ContentPlaceHolder1_ddl_Group");
//let ele4 = document.getElementById("ctl00_ContentPlaceHolder1_Schedule1");
//let check = false;
//for (
//  let i = 1;
//  i < ctl00_ContentPlaceHolder1_ddl_Department.options.length;
//  i++
//) {
//  console.log("i = " + i + " *************************");
//  while (
//    i != 1 &&
//    (document.getElementById("ctl00_ContentPlaceHolder1_ddl_Department") ==
//      null ||
//      ele1 ==
//        document.getElementById("ctl00_ContentPlaceHolder1_ddl_Department") ||
//      ctl00_ContentPlaceHolder1_ddl_Department.hasAttribute("disabled"))
//  ) {
//    await new Promise((r) => setTimeout(r, 500));
//    ctl00_ContentPlaceHolder1_ddl_Department.selectedIndex = i;
//    ctl00_ContentPlaceHolder1_ddl_Department.onchange();
//  }
//  await new Promise((r) => setTimeout(r, 500));
//  async function f1() {
//    try {
//      ctl00_ContentPlaceHolder1_ddl_Department.selectedIndex = i;
//      ctl00_ContentPlaceHolder1_ddl_Department.onchange();
//      await new Promise((r) => setTimeout(r, 500));
//    } catch {
//      console.log("f1".repeat(30));
//      f1();
//    }
//  }
//  f1();
//  check = true;
//  await new Promise((r) => setTimeout(r, 500));
//  ctl00_ContentPlaceHolder1_ddl_Department.selectedIndex = i;
//  ctl00_ContentPlaceHolder1_ddl_Department.onchange();
//  if (i != 1) {
//    ele1 = ctl00_ContentPlaceHolder1_ddl_Department;
//  }
//  console.log(1);
//  while (
//    ele2 == document.getElementById("ctl00_ContentPlaceHolder1_ddl_Period") ||
//    document.getElementById("ctl00_ContentPlaceHolder1_ddl_Period") == null ||
//    document
//      .getElementById("ctl00_ContentPlaceHolder1_ddl_Period")
//      .hasAttribute("disabled")
//  ) {
//    await new Promise((r) => setTimeout(r, 500));
//  }
//  await new Promise((r) => setTimeout(r, 500));
//  if (ctl00_ContentPlaceHolder1_ddl_Period.options.length > 6) {
//    async function f2() {
//      try {
//        ctl00_ContentPlaceHolder1_ddl_Period.selectedIndex = 6;
//        ctl00_ContentPlaceHolder1_ddl_Period.onchange();
//        ele2 = ctl00_ContentPlaceHolder1_ddl_Period;
//        await new Promise((r) => setTimeout(r, 500));
//      } catch {
//        console.log("f2".repeat(30));
//        f2();
//      }
//    }
//    f2();
//    await new Promise((r) => setTimeout(r, 800));
//
//    console.log(2);
//
//    while (
//      ele3 == document.getElementById("ctl00_ContentPlaceHolder1_ddl_Group") ||
//      document
//        .getElementById("ctl00_ContentPlaceHolder1_ddl_Group")
//        .hasAttribute("disabled")
//    ) {
//      await new Promise((r) => setTimeout(r, 500));
//      ctl00_ContentPlaceHolder1_ddl_Period.selectedIndex = 6;
//      ctl00_ContentPlaceHolder1_ddl_Period.onchange();
//    }
//    async function f3() {
//      try {
//        ctl00_ContentPlaceHolder1_ddl_Period.selectedIndex = 6;
//        ctl00_ContentPlaceHolder1_ddl_Period.onchange();
//        ele2 = ctl00_ContentPlaceHolder1_ddl_Period;
//        await new Promise((r) => setTimeout(r, 500));
//      } catch {
//        console.log("f3".repeat(30));
//        f3();
//      }
//    }
//    f3();
//    // await new Promise((r) => setTimeout(r, 800));
//
//    for (
//      let j = 1;
//      j <
//      document.getElementById("ctl00_ContentPlaceHolder1_ddl_Group").options
//        .length;
//      j++
//    ) {
//      while (
//        document
//          .getElementById("ctl00_ContentPlaceHolder1_ddl_Group")
//          .hasAttribute("disabled")
//      ) {
//        ctl00_ContentPlaceHolder1_ddl_Period.selectedIndex = 6;
//        ctl00_ContentPlaceHolder1_ddl_Period.onchange();
//        ele2 = ctl00_ContentPlaceHolder1_ddl_Period;
//        await new Promise((r) => setTimeout(r, 500));
//      }
//      async function f4() {
//        try {
//          document.getElementById(
//            "ctl00_ContentPlaceHolder1_ddl_Group"
//          ).selectedIndex = j;
//          document
//            .getElementById("ctl00_ContentPlaceHolder1_ddl_Group")
//            .onchange();
//          ele3 = ctl00_ContentPlaceHolder1_ddl_Group;
//          await new Promise((r) => setTimeout(r, 500));
//        } catch {
//          console.log("f4".repeat(30));
//          f4();
//        }
//      }
//      f4();
//
//      console.log(3);
//      await new Promise((r) => setTimeout(r, 500));
//
//      document.getElementById(
//        "ctl00_ContentPlaceHolder1_ddl_Group"
//      ).selectedIndex = j;
//      document.getElementById("ctl00_ContentPlaceHolder1_ddl_Group").onchange();
//      ele3 = ctl00_ContentPlaceHolder1_ddl_Group;
//      await new Promise((r) => setTimeout(r, 500));
//
//      while (
//        document.getElementById("ctl00_ContentPlaceHolder1_Schedule1") ==
//          ele4 ||
//        document.getElementById("ctl00_ContentPlaceHolder1_Schedule1") == null
//      ) {
//        await new Promise((r) => setTimeout(r, 500));
//      }
//      console.log(".............................");
//      await new Promise((r) => setTimeout(r, 500));
//
//      // async function f5() {
//      //   try {
//      //     ctl00_ContentPlaceHolder1_Schedule1 != null;
//      //     await new Promise((r) => setTimeout(r, 500));
//      //   } catch {
//      //     console.log("f5".repeat(30));
//      //     f5();
//      //   }
//      // }
//      // f5();
//      await new Promise((r) => setTimeout(r, 1000));
//
//      while (
//        document.getElementById("ctl00_ContentPlaceHolder1_Schedule1") == null
//      ) {
//        await new Promise((r) => setTimeout(r, 500));
//
//        document.getElementById(
//          "ctl00_ContentPlaceHolder1_ddl_Group"
//        ).selectedIndex = j;
//        document
//          .getElementById("ctl00_ContentPlaceHolder1_ddl_Group")
//          .onchange();
//        ele3 = ctl00_ContentPlaceHolder1_ddl_Group;
//      }
//      while (
//        document.getElementById("ctl00_ContentPlaceHolder1_Schedule1") ==
//          ele4 ||
//        document.getElementById("ctl00_ContentPlaceHolder1_Schedule1") == null
//      ) {
//        await new Promise((r) => setTimeout(r, 500));
//      }
//      ele4 = document.getElementById("ctl00_ContentPlaceHolder1_Schedule1");
//      console.log(".............................");
//      console.log(5);
//
//      await new Promise((r) => setTimeout(r, 500));
//      getArr();
//      await new Promise((r) => setTimeout(r, 500));
//    }
//    console.log(6);
//  }
//}
//console.log(myArr + myNames);

        arr[2][0].lec.day = 4;
        arr[2][0].lec.start = 1;
        arr[2][0].lec.end = 2;
        arr[2][0].lec.type = "lec";
        arr[2][0].lec.NumberOfKinds = 3;
        arr[2][0].lec.name = "CS322";
        arr[2][0].lec.ClassName = 0;
        arr[2][0].sec.day = 3;
        arr[2][0].sec.start = 5;
        arr[2][0].sec.end = 6;
        arr[2][0].sec.type = "sec";
        arr[2][0].sec.NumberOfKinds = 3;
        arr[2][0].sec.name = "CS322";
        arr[2][0].sec.ClassName = 0;
        arr[2][0].lab.day = 4;
        arr[2][0].lab.start = 7;
        arr[2][0].lab.end = 8;
        arr[2][0].lab.type = "lab";
        arr[2][0].lab.NumberOfKinds = 3;
        arr[2][0].lab.name = "CS322";
        arr[2][0].lab.ClassName = 0;
        arr[3][0].lec.day = 4;
        arr[3][0].lec.start = 3;
        arr[3][0].lec.end = 4;
        arr[3][0].lec.type = "lec";
        arr[3][0].lec.NumberOfKinds = 2;
        arr[3][0].lec.name = "CS366";
        arr[3][0].lec.ClassName = 0;
        arr[3][0].sec.day = 2;
        arr[3][0].sec.start = 7;
        arr[3][0].sec.end = 8;
        arr[3][0].sec.type = "sec";
        arr[3][0].sec.NumberOfKinds = 2;
        arr[3][0].sec.name = "CS366";
        arr[3][0].sec.ClassName = 0;
        arr[6][0].sec.day = 0;
        arr[6][0].sec.start = 1;
        arr[6][0].sec.end = 2;
        arr[6][0].sec.type = "sec";
        arr[6][0].sec.NumberOfKinds = 1;
        arr[6][0].sec.name = "IT331";
        arr[6][0].sec.ClassName = 0;
        arr[1][1].lec.day = 1;
        arr[1][1].lec.start = 3;
        arr[1][1].lec.end = 4;
        arr[1][1].lec.type = "lec";
        arr[1][1].lec.NumberOfKinds = 2;
        arr[1][1].lec.name = "IS374";
        arr[1][1].lec.ClassName = 1;
        arr[1][1].sec.day = 0;
        arr[1][1].sec.start = 5;
        arr[1][1].sec.end = 6;
        arr[1][1].sec.type = "sec";
        arr[1][1].sec.NumberOfKinds = 2;
        arr[1][1].sec.name = "IS374";
        arr[1][1].sec.ClassName = 1;
        arr[6][2].sec.day = 0;
        arr[6][2].sec.start = 3;
        arr[6][2].sec.end = 4;
        arr[6][2].sec.type = "sec";
        arr[6][2].sec.NumberOfKinds = 1;
        arr[6][2].sec.name = "IT331";
        arr[6][2].sec.ClassName = 2;
        arr[5][3].lec.day = 5;
        arr[5][3].lec.start = 5;
        arr[5][3].lec.end = 6;
        arr[5][3].lec.type = "lec";
        arr[5][3].lec.NumberOfKinds = 2;
        arr[5][3].lec.name = "CS305";
        arr[5][3].lec.ClassName = 3;
        arr[5][3].sec.day = 0;
        arr[5][3].sec.start = 1;
        arr[5][3].sec.end = 2;
        arr[5][3].sec.type = "sec";
        arr[5][3].sec.NumberOfKinds = 2;
        arr[5][3].sec.name = "CS305";
        arr[5][3].sec.ClassName = 3;
        arr[0][4].lec.day = 2;
        arr[0][4].lec.start = 3;
        arr[0][4].lec.end = 4;
        arr[0][4].lec.type = "lec";
        arr[0][4].lec.NumberOfKinds = 2;
        arr[0][4].lec.name = "CS301";
        arr[0][4].lec.ClassName = 4;
        arr[0][4].sec.day = 3;
        arr[0][4].sec.start = 1;
        arr[0][4].sec.end = 2;
        arr[0][4].sec.type = "sec";
        arr[0][4].sec.NumberOfKinds = 2;
        arr[0][4].sec.name = "CS301";
        arr[0][4].sec.ClassName = 4;
        arr[2][4].lec.day = 2;
        arr[2][4].lec.start = 5;
        arr[2][4].lec.end = 6;
        arr[2][4].lec.type = "lec";
        arr[2][4].lec.NumberOfKinds = 3;
        arr[2][4].lec.name = "CS322";
        arr[2][4].lec.ClassName = 4;
        arr[2][4].sec.day = 5;
        arr[2][4].sec.start = 5;
        arr[2][4].sec.end = 6;
        arr[2][4].sec.type = "sec";
        arr[2][4].sec.NumberOfKinds = 3;
        arr[2][4].sec.name = "CS322";
        arr[2][4].sec.ClassName = 4;
        arr[2][4].lab.day = 4;
        arr[2][4].lab.start = 9;
        arr[2][4].lab.end = 10;
        arr[2][4].lab.type = "lab";
        arr[2][4].lab.NumberOfKinds = 3;
        arr[2][4].lab.name = "CS322";
        arr[2][4].lab.ClassName = 4;
        arr[3][4].lec.day = 3;
        arr[3][4].lec.start = 3;
        arr[3][4].lec.end = 4;
        arr[3][4].lec.type = "lec";
        arr[3][4].lec.NumberOfKinds = 2;
        arr[3][4].lec.name = "CS366";
        arr[3][4].lec.ClassName = 4;
        arr[3][4].sec.day = 3;
        arr[3][4].sec.start = 5;
        arr[3][4].sec.end = 6;
        arr[3][4].sec.type = "sec";
        arr[3][4].sec.NumberOfKinds = 2;
        arr[3][4].sec.name = "CS366";
        arr[3][4].sec.ClassName = 4;
        arr[4][4].lec.day = 5;
        arr[4][4].lec.start = 9;
        arr[4][4].lec.end = 10;
        arr[4][4].lec.type = "lec";
        arr[4][4].lec.NumberOfKinds = 2;
        arr[4][4].lec.name = "CS312";
        arr[4][4].lec.ClassName = 4;
        arr[4][4].sec.day = 4;
        arr[4][4].sec.start = 7;
        arr[4][4].sec.end = 8;
        arr[4][4].sec.type = "sec";
        arr[4][4].sec.NumberOfKinds = 2;
        arr[4][4].sec.name = "CS312";
        arr[4][4].sec.ClassName = 4;
        arr[5][4].lec.day = 5;
        arr[5][4].lec.start = 3;
        arr[5][4].lec.end = 4;
        arr[5][4].lec.type = "lec";
        arr[5][4].lec.NumberOfKinds = 2;
        arr[5][4].lec.name = "CS305";
        arr[5][4].lec.ClassName = 4;
        arr[5][4].sec.day = 0;
        arr[5][4].sec.start = 5;
        arr[5][4].sec.end = 6;
        arr[5][4].sec.type = "sec";
        arr[5][4].sec.NumberOfKinds = 2;
        arr[5][4].sec.name = "CS305";
        arr[5][4].sec.ClassName = 4;
        arr[0][5].lec.day = 2;
        arr[0][5].lec.start = 5;
        arr[0][5].lec.end = 6;
        arr[0][5].lec.type = "lec";
        arr[0][5].lec.NumberOfKinds = 2;
        arr[0][5].lec.name = "CS301";
        arr[0][5].lec.ClassName = 5;
        arr[0][5].sec.day = 2;
        arr[0][5].sec.start = 1;
        arr[0][5].sec.end = 2;
        arr[0][5].sec.type = "sec";
        arr[0][5].sec.NumberOfKinds = 2;
        arr[0][5].sec.name = "CS301";
        arr[0][5].sec.ClassName = 5;
        arr[1][5].lec.day = 2;
        arr[1][5].lec.start = 3;
        arr[1][5].lec.end = 4;
        arr[1][5].lec.type = "lec";
        arr[1][5].lec.NumberOfKinds = 2;
        arr[1][5].lec.name = "IS374";
        arr[1][5].lec.ClassName = 5;
        arr[1][5].sec.day = 0;
        arr[1][5].sec.start = 7;
        arr[1][5].sec.end = 8;
        arr[1][5].sec.type = "sec";
        arr[1][5].sec.NumberOfKinds = 2;
        arr[1][5].sec.name = "IS374";
        arr[1][5].sec.ClassName = 5;
        arr[2][5].lec.day = 1;
        arr[2][5].lec.start = 3;
        arr[2][5].lec.end = 4;
        arr[2][5].lec.type = "lec";
        arr[2][5].lec.NumberOfKinds = 3;
        arr[2][5].lec.name = "CS322";
        arr[2][5].lec.ClassName = 5;
        arr[2][5].sec.day = 3;
        arr[2][5].sec.start = 1;
        arr[2][5].sec.end = 2;
        arr[2][5].sec.type = "sec";
        arr[2][5].sec.NumberOfKinds = 3;
        arr[2][5].sec.name = "CS322";
        arr[2][5].sec.ClassName = 5;
        arr[2][5].lab.day = 3;
        arr[2][5].lab.start = 3;
        arr[2][5].lab.end = 4;
        arr[2][5].lab.type = "lab";
        arr[2][5].lab.NumberOfKinds = 3;
        arr[2][5].lab.name = "CS322";
        arr[2][5].lab.ClassName = 5;
        arr[3][5].lec.day = 3;
        arr[3][5].lec.start = 5;
        arr[3][5].lec.end = 6;
        arr[3][5].lec.type = "lec";
        arr[3][5].lec.NumberOfKinds = 2;
        arr[3][5].lec.name = "CS366";
        arr[3][5].lec.ClassName = 5;
        arr[3][5].sec.day = 2;
        arr[3][5].sec.start = 7;
        arr[3][5].sec.end = 8;
        arr[3][5].sec.type = "sec";
        arr[3][5].sec.NumberOfKinds = 2;
        arr[3][5].sec.name = "CS366";
        arr[3][5].sec.ClassName = 5;
        arr[4][5].lec.day = 5;
        arr[4][5].lec.start = 7;
        arr[4][5].lec.end = 8;
        arr[4][5].lec.type = "lec";
        arr[4][5].lec.NumberOfKinds = 2;
        arr[4][5].lec.name = "CS312";
        arr[4][5].lec.ClassName = 5;
        arr[4][5].sec.day = 3;
        arr[4][5].sec.start = 7;
        arr[4][5].sec.end = 8;
        arr[4][5].sec.type = "sec";
        arr[4][5].sec.NumberOfKinds = 2;
        arr[4][5].sec.name = "CS312";
        arr[4][5].sec.ClassName = 5;
        arr[0][6].lec.day = 2;
        arr[0][6].lec.start = 5;
        arr[0][6].lec.end = 6;
        arr[0][6].lec.type = "lec";
        arr[0][6].lec.NumberOfKinds = 2;
        arr[0][6].lec.name = "CS301";
        arr[0][6].lec.ClassName = 6;
        arr[0][6].sec.day = 3;
        arr[0][6].sec.start = 7;
        arr[0][6].sec.end = 8;
        arr[0][6].sec.type = "sec";
        arr[0][6].sec.NumberOfKinds = 2;
        arr[0][6].sec.name = "CS301";
        arr[0][6].sec.ClassName = 6;
        arr[2][6].lec.day = 1;
        arr[2][6].lec.start = 3;
        arr[2][6].lec.end = 4;
        arr[2][6].lec.type = "lec";
        arr[2][6].lec.NumberOfKinds = 3;
        arr[2][6].lec.name = "CS322";
        arr[2][6].lec.ClassName = 6;
        arr[2][6].sec.day = 2;
        arr[2][6].sec.start = 3;
        arr[2][6].sec.end = 4;
        arr[2][6].sec.type = "sec";
        arr[2][6].sec.NumberOfKinds = 3;
        arr[2][6].sec.name = "CS322";
        arr[2][6].sec.ClassName = 6;
        arr[2][6].lab.day = 5;
        arr[2][6].lab.start = 3;
        arr[2][6].lab.end = 4;
        arr[2][6].lab.type = "lab";
        arr[2][6].lab.NumberOfKinds = 3;
        arr[2][6].lab.name = "CS322";
        arr[2][6].lab.ClassName = 6;
        arr[3][6].lec.day = 3;
        arr[3][6].lec.start = 5;
        arr[3][6].lec.end = 6;
        arr[3][6].lec.type = "lec";
        arr[3][6].lec.NumberOfKinds = 2;
        arr[3][6].lec.name = "CS366";
        arr[3][6].lec.ClassName = 6;
        arr[3][6].sec.day = 0;
        arr[3][6].sec.start = 5;
        arr[3][6].sec.end = 6;
        arr[3][6].sec.type = "sec";
        arr[3][6].sec.NumberOfKinds = 2;
        arr[3][6].sec.name = "CS366";
        arr[3][6].sec.ClassName = 6;
        arr[4][6].lec.day = 5;
        arr[4][6].lec.start = 7;
        arr[4][6].lec.end = 8;
        arr[4][6].lec.type = "lec";
        arr[4][6].lec.NumberOfKinds = 2;
        arr[4][6].lec.name = "CS312";
        arr[4][6].lec.ClassName = 6;
        arr[4][6].sec.day = 2;
        arr[4][6].sec.start = 7;
        arr[4][6].sec.end = 8;
        arr[4][6].sec.type = "sec";
        arr[4][6].sec.NumberOfKinds = 2;
        arr[4][6].sec.name = "CS312";
        arr[4][6].sec.ClassName = 6;
        arr[5][6].lec.day = 5;
        arr[5][6].lec.start = 5;
        arr[5][6].lec.end = 6;
        arr[5][6].lec.type = "lec";
        arr[5][6].lec.NumberOfKinds = 2;
        arr[5][6].lec.name = "CS305";
        arr[5][6].lec.ClassName = 6;
        arr[5][6].sec.day = 0;
        arr[5][6].sec.start = 3;
        arr[5][6].sec.end = 4;
        arr[5][6].sec.type = "sec";
        arr[5][6].sec.NumberOfKinds = 2;
        arr[5][6].sec.name = "CS305";
        arr[5][6].sec.ClassName = 6;
        arr[1][7].lec.day = 1;
        arr[1][7].lec.start = 3;
        arr[1][7].lec.end = 4;
        arr[1][7].lec.type = "lec";
        arr[1][7].lec.NumberOfKinds = 2;
        arr[1][7].lec.name = "IS374";
        arr[1][7].lec.ClassName = 7;
        arr[1][7].sec.day = 0;
        arr[1][7].sec.start = 3;
        arr[1][7].sec.end = 4;
        arr[1][7].sec.type = "sec";
        arr[1][7].sec.NumberOfKinds = 2;
        arr[1][7].sec.name = "IS374";
        arr[1][7].sec.ClassName = 7;
        arr[2][8].lec.day = 4;
        arr[2][8].lec.start = 1;
        arr[2][8].lec.end = 2;
        arr[2][8].lec.type = "lec";
        arr[2][8].lec.NumberOfKinds = 3;
        arr[2][8].lec.name = "CS322";
        arr[2][8].lec.ClassName = 8;
        arr[2][8].sec.day = 2;
        arr[2][8].sec.start = 7;
        arr[2][8].sec.end = 8;
        arr[2][8].sec.type = "sec";
        arr[2][8].sec.NumberOfKinds = 3;
        arr[2][8].sec.name = "CS322";
        arr[2][8].sec.ClassName = 8;
        arr[2][8].lab.day = 5;
        arr[2][8].lab.start = 1;
        arr[2][8].lab.end = 2;
        arr[2][8].lab.type = "lab";
        arr[2][8].lab.NumberOfKinds = 3;
        arr[2][8].lab.name = "CS322";
        arr[2][8].lab.ClassName = 8;
        arr[3][8].lec.day = 4;
        arr[3][8].lec.start = 3;
        arr[3][8].lec.end = 4;
        arr[3][8].lec.type = "lec";
        arr[3][8].lec.NumberOfKinds = 2;
        arr[3][8].lec.name = "CS366";
        arr[3][8].lec.ClassName = 8;
        arr[3][8].sec.day = 2;
        arr[3][8].sec.start = 5;
        arr[3][8].sec.end = 6;
        arr[3][8].sec.type = "sec";
        arr[3][8].sec.NumberOfKinds = 2;
        arr[3][8].sec.name = "CS366";
        arr[3][8].sec.ClassName = 8;
        arr[0][9].lec.day = 2;
        arr[0][9].lec.start = 3;
        arr[0][9].lec.end = 4;
        arr[0][9].lec.type = "lec";
        arr[0][9].lec.NumberOfKinds = 2;
        arr[0][9].lec.name = "CS301";
        arr[0][9].lec.ClassName = 9;
        arr[0][9].sec.day = 2;
        arr[0][9].sec.start = 1;
        arr[0][9].sec.end = 2;
        arr[0][9].sec.type = "sec";
        arr[0][9].sec.NumberOfKinds = 2;
        arr[0][9].sec.name = "CS301";
        arr[0][9].sec.ClassName = 9;
        arr[2][9].lec.day = 2;
        arr[2][9].lec.start = 5;
        arr[2][9].lec.end = 6;
        arr[2][9].lec.type = "lec";
        arr[2][9].lec.NumberOfKinds = 3;
        arr[2][9].lec.name = "CS322";
        arr[2][9].lec.ClassName = 9;
        arr[2][9].sec.day = 3;
        arr[2][9].sec.start = 9;
        arr[2][9].sec.end = 10;
        arr[2][9].sec.type = "sec";
        arr[2][9].sec.NumberOfKinds = 3;
        arr[2][9].sec.name = "CS322";
        arr[2][9].sec.ClassName = 9;
        arr[2][9].lab.day = 4;
        arr[2][9].lab.start = 7;
        arr[2][9].lab.end = 8;
        arr[2][9].lab.type = "lab";
        arr[2][9].lab.NumberOfKinds = 3;
        arr[2][9].lab.name = "CS322";
        arr[2][9].lab.ClassName = 9;
        arr[3][9].lec.day = 3;
        arr[3][9].lec.start = 3;
        arr[3][9].lec.end = 4;
        arr[3][9].lec.type = "lec";
        arr[3][9].lec.NumberOfKinds = 2;
        arr[3][9].lec.name = "CS366";
        arr[3][9].lec.ClassName = 9;
        arr[3][9].sec.day = 3;
        arr[3][9].sec.start = 7;
        arr[3][9].sec.end = 8;
        arr[3][9].sec.type = "sec";
        arr[3][9].sec.NumberOfKinds = 2;
        arr[3][9].sec.name = "CS366";
        arr[3][9].sec.ClassName = 9;
        arr[4][9].lec.day = 5;
        arr[4][9].lec.start = 9;
        arr[4][9].lec.end = 10;
        arr[4][9].lec.type = "lec";
        arr[4][9].lec.NumberOfKinds = 2;
        arr[4][9].lec.name = "CS312";
        arr[4][9].lec.ClassName = 9;
        arr[4][9].sec.day = 4;
        arr[4][9].sec.start = 9;
        arr[4][9].sec.end = 10;
        arr[4][9].sec.type = "sec";
        arr[4][9].sec.NumberOfKinds = 2;
        arr[4][9].sec.name = "CS312";
        arr[4][9].sec.ClassName = 9;
        ClassesNames[0] = "T6 GM Min CS";
        ClassesNames[1] = "T6 GM Min IS";
        ClassesNames[2] = "T6 GM Min SE";
        ClassesNames[3] = "share";
        ClassesNames[4] = "T6 CS Min GM";
        ClassesNames[5] = "T6 CS Min IS";
        ClassesNames[6] = "T6 CS Min SE";
        ClassesNames[7] = "T6 IS Min SE";
        ClassesNames[8] = "T6 IS Min CS";
        ClassesNames[9] = "T6 SE Class A";
//
//
//
//
//
        check = new sectionTime[7][5];

        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < check[0].length; j++) {
                check[i][j] = new sectionTime();
            }
        }

        getTheTables(0, arr);
//        getTheTables(0, 0);

        System.exit(0);

    }

    public static void main(String[] args) {
        //        String[] s = new String[3];
        //        System.out.println(s[0]);

        launch(args);
    }

}
