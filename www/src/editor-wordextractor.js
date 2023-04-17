wordsNotNeeded = [ "no", "ni", "wa", "ku", "de", "ga", "mo", "so", "y", "i"]

function sanitizeString(str){
    str = str.replace(/[^a-z0-9áéíóúñü\.,_-]/gim,"");
    return str.trim().toLowerCase();
}

function extractWords(text){
    let words = text.replace( /\n/g, " " ).split(" ");

    let goodwords = [];

    words.forEach(word =>{
        worde = sanitizeString(word);
        if(worde.length != 0 && wordsNotNeeded.indexOf(worde) == -1 && goodwords.indexOf(worde) == -1){
            goodwords.push(worde);
        }
    });

    return goodwords;
}