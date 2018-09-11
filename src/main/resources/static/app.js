function autoCompleteRequest(input, onload) {
    let request = new XMLHttpRequest()

    request.open('GET', `search/${encodeURI(input)}`, true)
    request.onload = () => {
        if (request.readyState == 4 && request.status == 200) {
            onload(JSON.parse(request.responseText))
        }
    }
    request.send()
}

function autoCompleteResponse(json) {
    
    replaceChilds(words, json.words)

    wordsSize.innerHTML = `${json.size} stations`

    if (json.suffixes) {
        suffix.value = search.value + json.suffixes[0]
        replaceChilds(chars)
    }
    else {
        suffix.value = ''
        replaceChilds(chars, json.characters, ['badge', 'badge-primary'])
    }

    charsSpacing.innerHTML = search.value
}

function replaceChilds(ul, arr, classes) {
    if (ul) {
        while (ul.firstChild) {
            ul.removeChild(ul.firstChild)
        }

        if (arr) {
            for (let i = 0; i < arr.length; ++i) {
                let li = document.createElement('li')
                li.innerHTML = arr[i];

                if (classes)
                    li.classList.add(...classes)

                ul.appendChild(li)
            }
        }
    }
}

window.onload = () => {
    
    search = document.getElementsByClassName('search')[0]

    charsContainer = document.createElement('div')
    charsContainer.className = 'chars-container'
    charsSpacing = document.createElement('span')
    charsSpacing.className = 'chars-spacing'
    chars = document.createElement('ul')
    chars.className = 'chars'

    wordsSizeContainer = document.createElement('div')
    wordsSizeContainer.className = 'words-size-container'
    wordsSize = document.createElement('span')
    wordsSize.className = 'badge badge-primary words-size'
    wordsSize.innerHTML = 0
    words = document.createElement('span')
    words.className = 'words'

    suffix = document.createElement('input')
    suffix.classList.add('form-control')
    suffix.classList.add('suffix')
    suffix.disabled = true

    search.parentNode.insertBefore(wordsSizeContainer, search)
    wordsSizeContainer.appendChild(wordsSize)
    search.parentNode.insertBefore(suffix, search)
    search.parentNode.appendChild(charsContainer)
    charsContainer.appendChild(charsSpacing)
    charsSpacing.parentNode.appendChild(chars)
    search.parentNode.appendChild(words)

    autoCompleteRequest('', autoCompleteResponse)
    search.oninput = (event) => {

        if (suffix.value.substr(0, search.value.length).toLowerCase() !== search.value.toLowerCase()) {
            suffix.value = ''
        }

        autoCompleteRequest(search.value, autoCompleteResponse)
    }
}