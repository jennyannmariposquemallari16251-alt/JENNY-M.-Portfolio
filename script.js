// Browser version of Jenny's Guess the Word game
const wordBank = {
  Math: {
    Easy: [
      ["PLUS", "A symbol used for addition."],
      ["CIRCLE", "A round shape."],
      ["NUMBER", "A mathematical value."]
    ],
    Medium: [
      ["FRACTION", "A part of a whole."],
      ["TRIANGLE", "A shape with three sides."],
      ["EQUATION", "A statement with an equal sign."]
    ],
    Hard: [
      ["PERCENTAGE", "A ratio expressed out of 100."],
      ["MULTIPLICATION", "Repeated addition of equal groups."],
      ["DENOMINATOR", "The bottom number of a fraction."]
    ]
  },
  Science: {
    Easy: [
      ["WATER", "We drink this every day."],
      ["PLANT", "A living thing that grows in soil."],
      ["SUN", "The star that gives Earth light."]
    ],
    Medium: [
      ["OXYGEN", "A gas humans need to breathe."],
      ["PLANET", "A large object that moves around a star."],
      ["GRAVITY", "The force that pulls objects downward."]
    ],
    Hard: [
      ["PHOTOSYNTHESIS", "The process plants use to make food."],
      ["EVAPORATION", "The process of liquid becoming gas."],
      ["ECOSYSTEM", "Living things interacting with their environment."]
    ]
  },
  English: {
    Easy: [
      ["BOOK", "Something you read."],
      ["HAPPY", "The opposite of sad."],
      ["APPLE", "A fruit that can be red or green."]
    ],
    Medium: [
      ["ADJECTIVE", "A word that describes a noun."],
      ["SYNONYM", "A word with a similar meaning."],
      ["VERB", "A word that shows an action."]
    ],
    Hard: [
      ["METAPHOR", "A comparison without like or as."],
      ["HYPERBOLE", "An extreme exaggeration."],
      ["ONOMATOPOEIA", "A word that imitates a sound."]
    ]
  }
};

const subjectEl = document.getElementById("subject");
const difficultyEl = document.getElementById("difficulty");
const startBtn = document.getElementById("startBtn");
const statusEl = document.getElementById("gameStatus");
const clueEl = document.getElementById("clue");
const form = document.getElementById("guessForm");
const guessInput = document.getElementById("guessInput");
const guessBtn = document.getElementById("guessBtn");
const attemptsEl = document.getElementById("attempts");
const nextBtn = document.getElementById("nextBtn");

let answer = "";
let attemptsLeft = 0;
let roundFinished = true;

function startRound() {
  const subject = subjectEl.value;
  const difficulty = difficultyEl.value;
  const choices = wordBank[subject][difficulty];
  const chosen = choices[Math.floor(Math.random() * choices.length)];

  answer = chosen[0];
  attemptsLeft = difficulty === "Easy" ? 8 : difficulty === "Medium" ? 6 : 4;
  roundFinished = false;

  statusEl.textContent = "Game started! Good luck!";
  clueEl.textContent = `Hint: ${chosen[1]}  |  Letters: ${answer.length}`;
  attemptsEl.textContent = `Attempts left: ${attemptsLeft}`;
  guessInput.value = "";
  guessInput.disabled = false;
  guessBtn.disabled = false;
  nextBtn.hidden = true;
  guessInput.focus();
}

function finishRound(won) {
  roundFinished = true;
  guessInput.disabled = true;
  guessBtn.disabled = true;
  nextBtn.hidden = false;

  if (won) {
    statusEl.textContent = "Correct! You got it! 🎉";
    attemptsEl.textContent = "Great job! Press Next Word to play another round.";
  } else {
    statusEl.textContent = "Game over!";
    attemptsEl.textContent = `The correct word is ${answer}. Press Next Word to try again.`;
  }
}

startBtn.addEventListener("click", startRound);

form.addEventListener("submit", (event) => {
  event.preventDefault();
  if (roundFinished) return;

  const guess = guessInput.value.trim().toUpperCase();
  if (!guess) {
    statusEl.textContent = "Please type your answer first.";
    return;
  }

  if (guess === answer) {
    finishRound(true);
    return;
  }

  attemptsLeft -= 1;
  if (attemptsLeft <= 0) {
    finishRound(false);
  } else {
    statusEl.textContent = "Not quite. Try again!";
    attemptsEl.textContent = `Attempts left: ${attemptsLeft}`;
    guessInput.select();
  }
});

nextBtn.addEventListener("click", startRound);
