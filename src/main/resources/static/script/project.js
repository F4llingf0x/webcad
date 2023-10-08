const tableRows = document.querySelectorAll(".projectTable tr");
const alreadySelectedRow = document.querySelectorAll(".projectTable tr.selected");
const notTableRows = document.querySelectorAll("body :not(.projectTable tr)")

const projectTable = document.getElementById("projectTable");
const addButton = document.getElementById("add");
const openButton = document.getElementById("open");
const deleteButton = document.getElementById("delete");
const form = document.getElementById("createForm");

let selectedRow = null;


tableRows.forEach(function (row) {
    row.addEventListener("click", function () {
        selectRow(row)
    });
});

addButton.addEventListener("click", function () {
    this.classList.add("disabled");
    form.classList.remove("disabled");
});

deleteButton.addEventListener("click", function () {
    startState();
});


function selectRow(row) {
    if (selectedRow !== null) {
        selectedRow.classList.remove("selected");
    }
    row.classList.add("selected");
    selectedRow = row;
    addButton.classList.add("disabled");
    openButton.classList.remove("disabled");
    deleteButton.classList.remove("disabled");
    form.classList.add("disabled");
};

document.addEventListener("click", function (event) {
    const clickedElement = event.target;

    if (!projectTable.contains(clickedElement) && selectedRow) {
        selectedRow.classList.remove("selected");
        selectedRow = null;
        startState();
    } else if(!form.contains(clickedElement) && !addButton.contains(clickedElement) && !projectTable.contains(clickedElement)){
        form.classList.add("disabled");
        addButton.classList.remove("disabled");
    }
});

function startState() {
    addButton.classList.remove("disabled");
    openButton.classList.add("disabled");
    deleteButton.classList.add("disabled");
}

