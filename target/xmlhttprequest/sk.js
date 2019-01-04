
var result;


function loadXMLDoc(){
    alert(" welcome inside function");
    var array1=[],i;
    

    var http = new XMLHttpRequest();
    var url = '/json';
    var params = '';
    http.open('POST', url, true);
    
    //Send the proper header information along with the request
    http.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    
    http.onreadystatechange = function() {//Call a function when the state changes.
        if(http.readyState == 4 && http.status == 200) {
            result=http.responseText;
            array1.push(result);
            alert(result);
        }
    }
    http.send(params);
}

// document.write(array1);
// document.write("*******"+result);

function contactchall() {
    
    var x="";
   
       x += "<table class='table'>";
       x += "<thead>";
       x += "<tr>";
       x += "<th>" + "id" + "</th>";
       x += "<th>" + "name" + "</th>";
       x += "<th>" + "price" + "</th>";
       x += "<th>" + "Edit" + "</th>";
       x += "<th>" + "Delete" + "</th>";
       x += "</tr>";
       x += "<tbody>";
      

    //     // x += "<h5><b>" + "Your inbox Details" + "</b></h5>";
        x += "<h5><td class='success'>" +object[i].id+ "</td></h5>";
        x += "<h5><td class='danger'>" +object[i].name+ "</td></h5>";
        // x += "<h5><td class='danger'>" +object[i].author+ "</td></h5>";
        x += "<h5><td class='danger'>" +object[i].price+ "</td></h5>";
        x+="<h5><td><button>" +"Edit" +"</h5></button></td>";
        x+="<h5><td><button>" +"Delete"+"</h5></button></td>";

     
    
     document.getElementById("demo").innerHTML = x;
   }