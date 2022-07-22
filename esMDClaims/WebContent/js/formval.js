function formVal(){
    if(document.getElementById("familyName").value == ""){
        alert("Please Enter Family Name");
        return false
    }else if(document.getElementById("givenName").value == ""){
        alert("Please Enter Given Name");
        return false
    }else if(document.getElementById("fullName").value == ""){
        alert("Please Enter Full Name");
        return false
    }else if(document.getElementById("userName").value == ""){
        alert("Please Enter User Name");
        return false
    }else if(document.getElementById("description").value == ""){
        alert("Please Enter Description");
        return false
    }else if(document.getElementById("localcommunity").value == 0){
        alert("Please Select Local Community");
        return false
    }else if(document.getElementById("file").value == ""){
        alert("Please Upload .PDF File");

        if(document.getElementById("file").value!=""){
            var id_value = document.getElementById("file");
            var fileName = id_value.value;
            var ext = fileName.substring(fileName.lastIndexOf('.') + 1);

            if (ext != "pdf"){
                alert("Plese Upload only PDF File only");
     
            }
        }
        return false
    }else if(document.getElementById("PatientID").value == ""){
        alert("Please Enter Patient ID");
        return false
    }else if(document.getElementById("documentID").value == ""){
        alert("Please Enter Document ID");
        return false
    }else if(document.getElementById("creationTime").value == ""){
        alert("Please Enter Creation Time");
        return false
    }else if(document.getElementById("serviceStartTime").value == ""){
        alert("Please Enter Service Start Time");
        return false
    }else if(document.getElementById("serviceStopTime").value == ""){
        alert("Please Enter Service Stop Time");
        return false
    }else if(document.getElementById("purposeCode").value == ""){
        alert("Please Enter Purpose Code");
        return false
    }

}