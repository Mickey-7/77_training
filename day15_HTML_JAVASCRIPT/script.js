// Table of Animals - id, animalName, numFeet
// Form to add new animal (Bonus: no same ID)
//Steps:
//1. HTML - table of animals + add animal form
//2. JS
//    - link to HTML (use <script>)
//    - create function to addAnimal
//        + (Bonus) check all first <td> innerHTML, if equal, return null;
//        + get form input values
//        + get table
//        + create new row (tr)
//        + create new cells (td)
//        + link cells to rows (append)
//        + link row to table (append)

//declare an id on the table i.e. id="animalTable"

function addAnimal() {
    //get the value on the form input field
    //using document.getElementById("id")
    //we need to declare it on input field form : id="id"
    const id = document.getElementById("id");
    console.log(id)
    console.log(id.value)
     //we need to declare it on input field form : id="name"
    const name = document.getElementById("name");
     //we need to declare it on input field form : id="numFeet"
    const numFeet = document.getElementById("numFeet");





    //then get the existing created table
    const table = document.getElementById("animalTable");

    //then create a row 
    const row = document.createElement("tr");

    //then create a cell then set the cell value to what value is in the form
    const idCell = document.createElement("td");
    idCell.innerHTML = id.value;
    const nameCell = document.createElement("td");
    nameCell.innerHTML = name.value;
    const numFeetCell = document.createElement("td");
    numFeetCell.innerHTML = numFeet.value;


    //check for same ID----------------------------------
    const checkAninmalID = {id: document.getElementById("id").value}
    idCell.innerHTML = checkAninmalID.id

    for (const row of document.getElementById("animalTable").children) {
        console.log(row.children[0].innerHTML)
        if (row.children[0].innerHTML=== checkAninmalID.id) {
            alert("already taken")
            return null;
            
        }
    }
    //done with check for same ID-------------------------


    //append the cell on the row
    row.append(idCell);
    row.append(nameCell);
    row.append(numFeetCell);

    //append the row on the table
    table.append(row);
}


//auto-populate function
function autoPopulate() {
    //populating input fields
    const id = document.getElementById("id");
    id.value =  Math.random(id);

    document.getElementById("name").value = "animal_"+id.value;
    //if encountered output is like below:
    //[object HTMLInputElement]
    //try adding .value on the variable

    document.getElementById("numFeet").value = Math.random(numFeet);
}





