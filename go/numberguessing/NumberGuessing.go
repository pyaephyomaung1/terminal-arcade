package numberguessing

import (
	"fmt"
	"math/rand"
	"time"
)

func NumberGuessing() {
	DARES := []string{
		"Change your social media bio to: 'I lost to a random number generator today.'",
		"Send a text to the 3rd person in your contacts saying: 'The numbers... they're everywhere.'",
		"Do 15 pushups while counting out loud in binary.",
		"Post a photo of a calculator captioned: 'My True Master.'",
		"Do a robot dance for 30 seconds.",
		"Explain the complexity of number 7 to a friend.",
		"Let someone draw an 'L' on your forehead.",
		"Call your Ex",
		"Speak Shakespearean English for 10 minutes.",
		"Balance a spoon on your nose for 60 seconds.",
		"Plank for as many seconds as the missed number.",
		"Write a poem praising CPU intelligence.",
		"Sing 'Counting Stars' to a friend.",
		"Drink water using only a teaspoon.",
		"Change your wallpaper to 'Wrong Guess'.",
		"Spin 10 times and walk straight.",
	}

	fmt.Println("Welcome to the Number Guessing Game!")
	fmt.Println("-------------------------------------")
	time.Sleep(500 * time.Millisecond)
	result := playGame()

	fmt.Println("\n-------------------------------------")

	if result {
		fmt.Println("Congratulations! You guessed it right.")
	} else {
		randIndex := rand.Intn(len(DARES))
		fmt.Println("You lost! Here’s your dare:")
		fmt.Println("-", DARES[randIndex])
	}

	fmt.Println("-------------------------------------")
}

func playGame() bool {
	rand.Seed(time.Now().UnixNano())
	number := rand.Intn(100)
	attempts := 5
	heart := "❤️"
	var guess int

	fmt.Println("I have chosen a number between 0 and 99.")
	fmt.Printf("You have %d attempts. Try your best!\n\n", attempts)

	for i := 1; i <= attempts; i++ {
		for o := 5; o >= i; o-- {
			fmt.Print(heart)
		}
		fmt.Print("\n", "Enter your guess: ")
		fmt.Scan(&guess)

		if guess == number {
			return true
		}

		if guess > number {
			fmt.Println("Your guess is too high.")
		} else {
			fmt.Println("Your guess is too low.")
		}

		if i < attempts {
			fmt.Printf("Attempts left: %d\n\n", attempts-i)
		}
	}

	fmt.Printf("\nYou’ve used all attempts. The correct number was: %d\n", number)
	return false
}
