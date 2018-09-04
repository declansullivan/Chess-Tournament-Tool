# Chess-Tournament-Tool
This program takes a group of players and matches them by skill, keeping track of their games.

<hr>

<h2>Introduction</h2>

I wrote this program my second year of AP Computer Science, senior year of high school. I was an International Baccaleaureate student, and a part of the program involved working with someone to create a program that could help them. My AP Calculus teacher also runs the chess club and asked me if I could make him a tool that would help him to manage tournaments.

The tool is relatively straightforward. You just need the Tournament.jar file and the chessinfo.txt file in the same directory. The chessinfo.txt file can be edited either outside or inside the program to add or remove player names from the tournament.

<hr>

<h2>Write-Up</h2>

<h3>Opening Window</h3>

When the program opens, the first window displayed shows the current players that are set to be put into the game.

<img src="/images/players.png"></img>

From here, the user has three options. They can edit the player list, where pushing the button will open the chessinfo.txt file, they can update the info they just added so that it displays to the screen, and they can start the tournament. Once the tournament is started, no more edits can be made to the player list.

<h3>Main Window</h3>

This window is where most of the tournament will take place. This window is divided into six main panels, which I will cover from left to right, top to bottom.

<img src="/images/mainwindow.png"></img>

<h4>Player List</h4>

First is the Player List panel. This is solely to keep tabs on who is in the tournament.

<h4>Outcome Input</h4>

Next is the Outcome Input panel. This is where the user can signal who won during the round of chess by clicking their respective button. If a player has no opponent, then the draw button and the nonexistant opponent buttons will be blanked out to avoid an accidental click.

<h4>Current Leaderboard</h4>

The next panel is for displaying the current leaderboard. The leaderboard is updated immediately when a game result is entered using the buttons, and the leaderboard is then sorted once the next round starts. If a player wins they get one point, each player is awarded half a point in the event of a tie, and the loser of a round gets zero points.

<h4>Current Matchup</h4>

The bottom right panel displays the current matchup. This section simply shows who should be going against who, and what color side they are on, depending on their highlighted name.

<h4>Settings and Options</h4>

After that is the settings area. I added this so that the instructions could be brought up if instructions.txt is in the same directory, and also so that the total number of rounds can be updated, as well as the background color of the window. I added the ability to change the color because I just wanted to get experience with JSliders, and it was a fun break from fixing bugs.

<img src="/images/color.png"></img>
<img src="/images/mainwindowcolor.png"></img>

The alter rounds button lets you set a new number of rounds to complete. You can set it to be higher or lower than it currently is, but not lower or equal to the current amount of rounds you are on.

<h4>Player Stats</h4>

The final window is for choosing a player for which to display statistics. When you click on a button, a window pops up to give you information about the player, including the number of games they have played, times they have played a round where they had no opponent, times they have been black or white, and their current score.

<img src="/images/stats.png"></img>

<h4>Bottom Buttons</h4>

The buttons along the bottom bar give three options. They are to progress to the next round, to display a spreadsheet, and to close the program. The next round button is disabled and only enabled to be used when all games in the round have been completed. This button also disappears when the total desired number of rounds has been completed, and is replaced by a button that will display the final standings in the spreadsheet.

<img src="/images/buttons.png"></img>

The spreadsheet button brings up a spreadsheet of all player activity throughout the tournament. Each player has a cell for each round showing who they played, if they won, and what color they were.

<img src="/images/spreadsheet.png"></img>

<hr>

<h2>Code Descriptions</h2>

There were some portions of the code that I feel I should explain, so here's that.

<h3>Player Object</h3>

Each player in the tournament was a Player object. This allowed me to easily keep track of how many times they had been unopposed, their current color, how many times they had been each color, the number of games they had played, and how many points they had.

Some of this information was incredibly useful for other portions of the program.

<h3>Matchups</h3>

Players were matched up based on how my teacher wanted them to be, which was by skill level. The way I went about this was by splitting the original list of players in half, and having each person play their matching index in each list. Once the first round was over, some people would rise to the top based off of their scores, so after the first round players are assigned to go against people who have similar scores, so that hopefully the fights will be fair.

In the event that there is an odd number of players, there is a redundancy in place. The player with the lowest score will be paired with a Free Pass player. This is a guaranteed win for them that gives them a point at the end of the round, helping them to move up and possibly fight someone else.

There was also another part of making sure the fights were fair, which was making sure that each person got to play each color an equal amount of times. When a matchup of players was created, their color would be determined by who had played white the least. Whoever that was got to be white, the other being black. If both had been white equal times, then it was randomly decided.

<hr>

<h2>Conclusion</h2>

This was one of my first large programming projects and it was pretty fun to do. I'm quite proud of it and look forward to working on more.
