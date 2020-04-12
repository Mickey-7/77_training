function addItem(){
    //read input field value and store it in an object item
    const item = {
        id: document.getElementById("id").value,
        name: document.getElementById("name").value,
        price: document.getElementById("price").value,
        year: document.getElementById("date").value
    }

    //set table and tbody
    var table = document.getElementById("table").getElementsByTagName("tbody")[0];
    //insert row length on the table and tbody
    var row = table.insertRow(table.length);

    //create cells on row and store the input field values on it
    idCell = row.insertCell("0");
    idCell.innerHTML = item.id;
    nameCell = row.insertCell("1");
    nameCell.innerHTML = item.name;
    priceCell = row.insertCell("2");
    priceCell.innerHTML = item.price;
    yearCell = row.insertCell("3");
    yearCell.innerHTML = item.year;
 
    //clear input fields
    document.getElementById("id").value="";
    document.getElementById("name").value="";
    document.getElementById("price").value="";
    document.getElementById("date").value="";

    // //other solution
    // //get table and create new row
    // const table = document.getElementById("table");
    // const row = document.createElement("tr");
    // //create cell and set the item object value
    // const idCell = document.createElement("td");
    // idCell.innerHTML = item.id
    // const nameCell = document.createElement("td");
    // nameCell.innerHTML = item.name
    // const priceCell = document.createElement("td");
    // priceCell.innerHTML = item.price
    // const yearCell = document.createElement("td");
    // yearCell.innerHTML = item.year
    // //append the cell on the row
    // row.append(idCell);
    // row.append(nameCell);
    // row.append(priceCell);
    // row.append(yearCell);
    // //append the row on the table
    // table.append(row);
}

function removeItem(removeID){
    for (row of document.getElementById("table").children[0].children) {
        if (row.children[0].innerHTML === removeID.value) {
            row.remove();
            //clear input fields
            document.getElementById("id").value="";
        }
    }

    //dont put [1] on for loop of document.getElementById("table").children[0].children
    //as it only pertains to particular object - error on console will be :
    //Uncaught TypeError: document.getElementById.children[1] is not iterable

    //MUST see READ ME.txt for detailed experiment on console 
}

function updateItem(updateID){
    for (row of document.getElementById("table").children[0].children) {
        if (row.children[0].innerHTML === updateID.value) {
            row.children[1].innerHTML = newName.value
            row.children[2].innerHTML = newPrice.value

            //clear input fields
            document.getElementById("id").value="";
            document.getElementById("name").value="";
            document.getElementById("price").value="";
        }
        
    }
}

function getItemByID(getID){
    for (row of document.getElementById("table").children[0].children) {
        if (row.children[0].innerHTML === getID.value) {
            //create a table
            const tableGet = document.getElementById("tableGet").createTBody("tbody");
            const rowGet = document.createElement("tr");

            idCell = document.createElement("td")
            idCell.innerHTML = row.children[0].innerHTML
            
            nameCell = document.createElement("td")
            nameCell.innerHTML = row.children[1].innerHTML
            
            priceCell = document.createElement("td")
            priceCell.innerHTML = row.children[2].innerHTML
            
            yearCell = document.createElement("td")
            yearCell.innerHTML = row.children[3].innerHTML

            rowGet.append(idCell)
            rowGet.append(nameCell)
            rowGet.append(priceCell)
            rowGet.append(yearCell)

            tableGet.append(rowGet)

            //clear input fields
            document.getElementById("id").value="";


        }
        
    }
}

function getItemByName(getName){
    for (row of document.getElementById("table").children[0].children) {
        if (row.children[1].innerHTML === getName.value) {
            //create a table
            const tableGet = document.getElementById("tableGetName").createTBody("tbody");
            const rowGet = document.createElement("tr");

            idCell = document.createElement("td")
            idCell.innerHTML = row.children[0].innerHTML
            
            nameCell = document.createElement("td")
            nameCell.innerHTML = row.children[1].innerHTML
            
            priceCell = document.createElement("td")
            priceCell.innerHTML = row.children[2].innerHTML
            
            yearCell = document.createElement("td")
            yearCell.innerHTML = row.children[3].innerHTML

            rowGet.append(idCell)
            rowGet.append(nameCell)
            rowGet.append(priceCell)
            rowGet.append(yearCell)

            tableGet.append(rowGet)
            
            //clear the input field
            document.getElementById("name").value="";

        }
        
    }
}