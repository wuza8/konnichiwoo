saveNewInput = null;
savedPlace = null;

function initSave(){
    saveNewInput = document.querySelector("#save-new-save-name-input");
    savedPlace = document.querySelector("#save-saved-place");

    showSaved();
}

function getSaves(){
    let saves = localStorage.getItem("editorSaves");
    if(saves==null || saves==""){
        localStorage.setItem("editorSaves", "[]");
        saves = localStorage.getItem("editorSaves");
        console.log(saves);
    }

    console.log(saves);
    return JSON.parse(saves);
}

function saveSaves(saves){
    localStorage.setItem("editorSaves", JSON.stringify(saves));
}

function saveNew(){
    let name = saveNewInput.value;

    let saves = getSaves();

    if(saves.find(save => save.saveName == name) != null){
        alert("Save with that name already exists! Change name!");
        return;
    }

    saves.push({
        saveName: name,
        save: artCreator.creation
    });
    saveSaves(saves);

    alert("Saved!");

    showSaved();
}

function showSaved(){
    let saves = getSaves();

    savedPlace.innerHTML = "";

    saves.forEach(save => {

        savedPlace.innerHTML += `<a onclick='loadSave("${save.saveName}")'>${save.saveName}</a>`;
    })
}

function loadSave(saveName){
    let saves = getSaves();

    artCreator.creation = saves.find(save => save.saveName == saveName).save;
    console.log(artCreator.creation);
    onload();
}

