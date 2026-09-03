  
    // Initial stories featuring learner Alex and Classic Fairy Tales
    let allStories = JSON.parse(localStorage.getItem('lingo_stories_v5')) || [
      {
        id: "cinderella_1",
        title: "Cinderella and the Glass Slipper",
        level: "B1",
        theme: "Fairy Tale",
        description: "A classic tale of kindness, magic, and a lost shoe.",
        imageUrl: "https://image.pollinations.ai/prompt/Cinderella%20running%20away%20from%20castle%20leaving%20glass%20slipper%20storybook%20illustration?width=800&height=400&nologo=true",
        raw: "Once upon a time, there [T:lived](Past Simple - State of being) a [ADJ:kind-hearted](Descriptive Adjective - Compassionate) girl named [N:Cinderella](Proper Noun - Main character). She [T:was forced](Past Simple Passive - Action done to her) to work [ADV:endlessly](Adverb of Frequency - Without stopping) by her [ADJ:cruel](Descriptive Adjective - Mean) stepmother. [C:Despite](Preposition/Conjunction - Shows contrast) her difficult life, she [T:remained](Past Simple - Continued to be) [ADJ:hopeful](Descriptive Adjective - Full of hope).\n\nOne evening, the King [T:invited](Past Simple - Action of offering an invitation) everyone [P:to](Preposition of Direction) a royal ball. Cinderella [T:could not go](Modal Verb - Lack of ability) because she had no dress. [ADV:Suddenly](Adverb of Manner - Unexpectedly), her Fairy Godmother [T:appeared](Past Simple - Sudden action). With a wave of her [ADJ:magic](Descriptive Adjective) wand, she [T:transformed](Past Simple - Changed completely) a pumpkin into a [L:magnificent](Extremely beautiful - B1) carriage.\n\n\"You must return [P:by](Preposition of Time) midnight,\" the Godmother [T:warned](Past Simple - Gave a caution). At the ball, the Prince [T:was captivated](Past Simple Passive - Deeply attracted) by her. [C:However](Conjunctive Adverb - Shows contrast), when the clock [T:struck](Past Simple - Sounded) twelve, she [T:fled](Past Simple - Ran away quickly), leaving [P:behind](Preposition of Place) a single glass slipper. The Prince used it to find her, and they lived [ADV:happily](Adverb of Manner) ever after.",
        quiz: [
          { type: "mc", question: "Reference: What does 'it' refer to in the sentence 'The Prince used it to find her'?", options: ["The carriage", "The glass slipper", "The pumpkin"], correct: 1, explanation: "'It' refers back to the single glass slipper she left behind." },
          { type: "mc", question: "Sequence: What is the correct chronological order of events?", options: ["Godmother appears -> Cinderella goes to the ball -> Leaves slipper", "Leaves slipper -> Godmother appears -> Cinderella goes to the ball", "Cinderella goes to the ball -> Godmother appears -> Leaves slipper"], correct: 0, explanation: "First the Godmother transforms the pumpkin, then Cinderella attends the ball, and finally she flees leaving the slipper." },
          { type: "mc", question: "Character: Which adjective best describes the stepmother?", options: ["Cruel", "Kind-hearted", "Magnificent"], correct: 0, explanation: "The text explicitly states she was forced to work endlessly by her 'cruel' stepmother." },
          { type: "mc", question: "Vocabulary Table: Complete the word family table: Noun: Magic, Adjective: Magical, Adverb: [?]", options: ["Magicalness", "Magic", "Magically"], correct: 2, explanation: "The adverb form of magic is 'magically'." },
          { type: "open", question: "Personal Opinion: Do you think Cinderella should have forgiven her stepmother at the end?" }
        ]
      },
      {
        id: "red_riding_hood_1",
        title: "Little Red Riding Hood",
        level: "A2",
        theme: "Fairy Tale",
        description: "A young girl's journey through the forest to visit her grandmother.",
        imageUrl: "https://image.pollinations.ai/prompt/Little%20Red%20Riding%20Hood%20walking%20in%20a%20dark%20forest%20storybook%20illustration?width=800&height=400&nologo=true",
        raw: "[N:Little Red Riding Hood](Proper Noun - Main character) [T:was walking](Past Continuous - Ongoing action in the past) through the [ADJ:dark](Descriptive Adjective) forest to visit her sick [N:grandmother](Noun - Family member). She [T:carried](Past Simple - Action) a [L:basket](A container for carrying things - A2) full of sweet treats. [S:Relative Clause:While she was picking flowers](Dependent clause showing simultaneous action), a [ADJ:cunning](Descriptive Adjective - Clever and deceitful) wolf [T:approached](Past Simple - Moved closer) her.\n\n\"Where are you going?\" the wolf [T:asked](Past Simple) [ADV:slyly](Adverb of Manner - In a sneaky way). She [T:told](Past Simple) him the truth [C:because](Subordinating Conjunction - Shows reason) she was [ADJ:innocent](Descriptive Adjective - Naive or pure). The wolf [T:ran](Past Simple) ahead [P:to](Preposition of Direction) the cottage, intending to trick them.\n\n[ADV:Fortunately](Adverb of Evaluation - Luckily), a [ADJ:brave](Descriptive Adjective - Courageous) woodcutter [T:heard](Past Simple - Perceived sound) the noise and [T:rescued](Past Simple - Saved from danger) them just in time. Little Red Riding Hood [T:learned](Past Simple - Acquired knowledge) never to speak to strangers [P:in](Preposition of Place) the woods again.",
        quiz: [
          { type: "mc", question: "Reference: Who does 'him' refer to in the sentence 'She told him the truth'?", options: ["The woodcutter", "The wolf", "Her grandmother"], correct: 1, explanation: "'Him' refers to the cunning wolf she was talking to." },
          { type: "mc", question: "Sequence: What is the correct chronological order of events?", options: ["Meets wolf -> Wolf runs to cottage -> Woodcutter rescues them", "Woodcutter rescues them -> Meets wolf -> Wolf runs to cottage", "Wolf runs to cottage -> Meets wolf -> Woodcutter rescues them"], correct: 0, explanation: "She meets the wolf while picking flowers, the wolf runs ahead, and then the woodcutter saves them." },
          { type: "mc", question: "Character: Which adjective best describes the wolf?", options: ["Brave", "Innocent", "Cunning"], correct: 2, explanation: "The story specifically describes the wolf as 'cunning' and speaking 'slyly'." },
          { type: "mc", question: "Vocabulary Table: Complete the word family table: Noun: Innocence, Adjective: Innocent, Adverb: [?]", options: ["Innocently", "Innocent", "Innocents"], correct: 0, explanation: "The adverb form of innocent is 'innocently'." },
          { type: "open", question: "Personal Opinion: Why is it important to be careful when talking to strangers?" }
        ]
      },
      {
        id: "alex_journey_1",
        title: "Alex's First Journey to London",
        level: "A2",
        theme: "Travel",
        description: "Alex's first adventure exploring London",
        imageUrl: "https://image.pollinations.ai/prompt/London%20Big%20Ben%20travel%20illustration%20storybook?width=800&height=400&nologo=true",
        raw: "[N:Alex](Subject Noun - Main traveler) [T:wakes up](Present Simple - Routine & habit) [ADV:early](Adverb of Time - Modifies 'wakes up') today [C:because](Subordinating Conjunction - Explains cause) it is his [ADJ:first](Ordinal Adjective - Modifies 'day') day in [N:London](Proper Noun - Destination city). He [T:feels](Present Simple - Stative verb of emotion) a bit [L:nervous](Anxious or worried - A2) about navigating the underground, [C:but](Coordinating Conjunction - Shows contrast) his [N:enthusiasm](Abstract Noun - Key motivation) keeps him going.\n\nAfter a [L:hearty](Substantial and satisfying - A2) [N:breakfast](Concrete Noun - Morning meal) at a [ADJ:cozy](Descriptive Adjective - Warm & comfortable) local cafe, he decides to visit Big Ben. [S:Relative Clause:While he is waiting for the bus](Dependent temporal clause describing simultaneous actions), an [ADJ:elderly](Descriptive Adjective - Modifies 'lady') lady [ADV:kindly](Adverb of Manner - Modifies 'offers') offers directions. She [T:explains](Present Simple - General truth) the city route with great detail. \n\nAlex thanks her [ADV:warmly](Adverb of Manner - Expressing gratitude) [C:and](Coordinating Conjunction - Connects actions) walks [P:towards](Preposition of Direction - Indicates movement to destination) the station. He feels [L:confident](Feeling sure of oneself - A2) that this trip will be unforgettable. It is the beginning of a beautiful journey.",
        quiz: [
          { type: "mc", question: "Reference: What does 'it' refer to in the sentence 'It is the beginning of a beautiful journey'?", options: ["The bus", "The trip to London", "The breakfast"], correct: 1, explanation: "'It' refers back to the overall trip and experience he is having." },
          { type: "mc", question: "Sequence: What is the correct chronological order of events?", options: ["Wakes up -> Eats breakfast -> Waits for bus -> Thanks lady", "Eats breakfast -> Wakes up -> Waits for bus -> Thanks lady", "Waits for bus -> Wakes up -> Eats breakfast -> Thanks lady"], correct: 0, explanation: "Alex wakes up, then has a hearty breakfast, then waits for the bus, and finally thanks the elderly lady." },
          { type: "mc", question: "Character: Which adjective best describes the elderly lady?", options: ["Selfish", "Helpful", "Nervous"], correct: 1, explanation: "She is helpful because she kindly offers directions and explains the route in detail." },
          { type: "mc", question: "Vocabulary Table: Complete the word family table: Noun: Confidence, Verb: Confide, Adjective: [?]", options: ["Confidently", "Confidant", "Confident"], correct: 2, explanation: "The adjective form of confidence is 'confident'." },
          { type: "open", question: "Personal Opinion: Have you ever been nervous on a trip? How did you handle it?" }
        ]
      },
      {
        id: "treasure_hunt",
        title: "Treasure Hunt",
        level: "B1",
        theme: "Adventure Stories",
        description: "An exciting expedition to find a legendary island treasure.",
        imageUrl: "https://image.pollinations.ai/prompt/Treasure%20Hunt%20pirate%20map%20adventure%20storybook%20illustration?width=800&height=400&nologo=true",
        raw: "Captain [N:James](Proper Noun - Explorer) [T:discovered](Past Simple - Found) an [ADJ:ancient](Descriptive Adjective - Very old) parchment map [P:inside](Preposition of Place) a dusty chest. The map [T:pointed](Past Simple - Indicated) toward Whispering Island, a place [T:shrouded](Past Simple Passive - Covered) in mystery. [C:Although](Conjunctive - Contrast) the journey was [ADJ:treacherous](Descriptive Adjective - Dangerous), his crew sailed [ADV:bravely](Adverb of Manner) through the stormy seas.\n\nUpon [T:landing](Gerund - Arriving on shore), they followed three golden markers [P:past](Preposition of Position) the roaring waterfall. There, beneath the roots of an [ADJ:immense](Descriptive Adjective - Huge) banyan tree, they [T:uncovered](Past Simple - Revealed) the chest of gold. It was a victory to remember.",
        quiz: [
          { type: "mc", question: "Reference: What does 'The map' point toward?", options: ["Whispering Island", "A dusty chest", "A stormy sea"], correct: 0, explanation: "The map pointed toward Whispering Island." },
          { type: "mc", question: "Sequence: What is the correct order of events?", options: ["Found map -> Sailed seas -> Uncovered chest", "Sailed seas -> Found map -> Uncovered chest", "Uncovered chest -> Found map -> Sailed seas"], correct: 0, explanation: "Captain James first found the map, then sailed through the stormy seas, and finally uncovered the chest." },
          { type: "mc", question: "Character: Which word describes the journey?", options: ["Treacherous", "Boring", "Easy"], correct: 0, explanation: "The text states the journey was treacherous." },
          { type: "mc", question: "Vocabulary Table: Complete: Noun: Adventure, Adjective: Adventurous, Adverb: [?]", options: ["Adventurously", "Adventure", "Adventuring"], correct: 0, explanation: "The adverb form is 'adventurously'." },
          { type: "open", question: "Personal Opinion: Would you embark on a dangerous treasure hunt? Why or why not?" }
        ]
      },
      {
        id: "best_friends",
        title: "Best Friends",
        level: "A2",
        theme: "Friendship Stories",
        description: "A heartwarming tale about loyalty and companionship.",
        imageUrl: "https://image.pollinations.ai/prompt/two%20best%20friends%20smiling%20together%20storybook%20illustration?width=800&height=400&nologo=true",
        raw: "[N:Maya](Proper Noun) and [N:Leo](Proper Noun) [T:have been](Present Perfect - Ongoing state) best friends [P:since](Preposition of Time) childhood. They [T:shared](Past Simple) every secret and [T:supported](Past Simple) each other [ADV:constantly](Adverb of Frequency). [C:When](Subordinating Conjunction) Leo [T:faced](Past Simple) a difficult math test, Maya [T:stayed](Past Simple) up late [P:with](Preposition) him [P:to](Preposition) study.\n\nThanks [P:to](Preposition) their teamwork, Leo [T:passed](Past Simple) with flying colors. He [T:promised](Past Simple) to help Maya with her art project in return. True friendship [T:means](Present Simple - General truth) standing [P:by](Preposition) one another through thick and thin.",
        quiz: [
          { type: "mc", question: "Reference: Who helped Leo study for his math test?", options: ["Maya", "His teacher", "His brother"], correct: 0, explanation: "Maya stayed up late with him to study." },
          { type: "mc", question: "Sequence: What happened first?", options: ["Leo faced a difficult math test", "Leo passed the test", "Maya painted a picture"], correct: 0, explanation: "Leo faced the difficult math test first, leading Maya to help him." },
          { type: "mc", question: "Character: How did Maya help Leo?", options: ["She stayed up late to study with him", "She took the test for him", "She bought him a book"], correct: 0, explanation: "Maya stayed up late with him to study." },
          { type: "mc", question: "Vocabulary Table: Complete: Noun: Friend, Adjective: Friendly, Adverb: [?]", options: ["Friendship", "Friendlily", "Friendly"], correct: 1, explanation: "The adverb form of friendly is friendlily (or in a friendly manner)." },
          { type: "open", question: "Personal Opinion: What is the most important quality in a best friend?" }
        ]
      },
      {
        id: "earth_moon",
        title: "Earth and Its Moon",
        level: "B1",
        theme: "Space Education",
        description: "Exploring the fascinating cosmic bond between our planet and its lunar partner.",
        imageUrl: "https://image.pollinations.ai/prompt/Earth%20and%20its%20Moon%20in%20space%20educational%20storybook%20illustration?width=800&height=400&nologo=true",
        raw: "The [N:Earth](Proper Noun) and the [N:Moon](Proper Noun) [T:share](Present Simple - Scientific fact) a [ADJ:gravitational](Descriptive Adjective) dance that [T:stabilizes](Present Simple) our planet's axial tilt. [C:While](Conjunction) the Moon [T:orbits](Present Simple) Earth [ADV:smoothly](Adverb of Manner), its gravitational pull [T:creates](Present Simple) ocean tides.\n\nWithout this [ADJ:celestial](Descriptive Adjective) companion, Earth's climate [T:would be](Conditional - Unreal present) drastically more erratic. Scientists [T:continue](Present Simple) [P:to](Preposition) study this [ADJ:unique](Descriptive Adjective) relationship [P:to](Preposition) understand planetary formation across the cosmos.",
        quiz: [
          { type: "mc", question: "Reference: What creates ocean tides on Earth?", options: ["The Moon's gravitational pull", "Solar flares", "Wind currents"], correct: 0, explanation: "The Moon's gravitational pull creates ocean tides." },
          { type: "mc", question: "Sequence: What does the Moon do smoothly?", options: ["Orbits Earth", "Rotates on its axis", "Cools down"], correct: 0, explanation: "The Moon orbits Earth smoothly." },
          { type: "mc", question: "Character: Which adjective describes the Moon in relation to Earth?", options: ["Celestial companion", "Distant star", "Gas giant"], correct: 0, explanation: "The Moon is described as a celestial companion." },
          { type: "mc", question: "Vocabulary Table: Complete: Noun: Universe, Adjective: Universal, Adverb: [?]", options: ["Universally", "Universe", "Universalist"], correct: 0, explanation: "The adverb form is universally." },
          { type: "open", question: "Personal Opinion: Why is space education important for humanity's future?" }
        ]
      },
      {
        id: "lazy_donkey",
        title: "Lazy Donkey",
        level: "A2",
        theme: "Motivational Stories",
        description: "A humorous fable about hard work and learning responsibility.",
        imageUrl: "https://image.pollinations.ai/prompt/lazy%20donkey%20resting%20in%20a%20sunny%20meadow%20storybook%20illustration?width=800&height=400&nologo=true",
        raw: "Once, a [ADJ:stubborn](Descriptive Adjective) donkey [T:named](Past Simple) Dolo [T:refused](Past Simple) [P:to](Preposition) carry heavy sacks of salt [P:across](Preposition) the river. He [ADV:always](Adverb of Frequency) [T:tried](Past Simple) [P:tofind](Verb) shortcuts. One hot afternoon, he [T:decided](Past Simple) [P:to](Preposition) roll [P:in](Preposition) the shallow water, dissolving the salt and [T:making](Present Participle) his load [ADJ:light](Descriptive Adjective).\n\n[C:However](Conjunctive Adverb), his master [T:noticed](Past Simple) the trick [P:on](Preposition) the next trip and [T:loaded](Past Simple) the donkey with heavy wet sponges instead! When Dolo rolled [P:in](Preposition) the water again, the sponges [T:absorbed](Past Simple) tons of water, becoming [ADJ:ten times heavier](Comparative Adjective). Dolo [T:learned](Past Simple) his lesson about hard work [ADV:immediately](Adverb of Time).",
        quiz: [
          { type: "mc", question: "Reference: What did Dolo carry on the second trip?", options: ["Heavy wet sponges", "Sacks of salt", "Bags of wool"], correct: 0, explanation: "His master loaded him with heavy wet sponges." },
          { type: "mc", question: "Sequence: What happened when Dolo rolled in the water with sponges?", options: ["They absorbed water and became much heavier", "They dissolved completely", "They floated away"], correct: 0, explanation: "The sponges absorbed tons of water and became much heavier." },
          { type: "mc", question: "Character: Which word describes Dolo at the beginning?", options: ["Stubborn and lazy", "Hardworking", "Clever"], correct: 0, explanation: "Dolo tried to find shortcuts and refused to carry heavy sacks." },
          { type: "mc", question: "Vocabulary Table: Complete: Noun: Laziness, Adjective: Lazy, Adverb: [?]", options: ["Lazily", "Lazy", "Laziness"], correct: 0, explanation: "The adverb form is lazily." },
          { type: "open", question: "Personal Opinion: Why is trying to find dishonest shortcuts usually a bad idea?" }
        ]
      },
      {
        id: "the_butterfly",
        title: "The Butterfly",
        level: "A2",
        theme: "Inspirational Stories",
        description: "The inspiring transformation of a caterpillar into a magnificent butterfly.",
        imageUrl: "https://image.pollinations.ai/prompt/a%20beautiful%20butterfly%20emerging%20from%20cocoon%20storybook%20illustration?width=800&height=400&nologo=true",
        raw: "A small [N:caterpillar](Noun) [T:spent](Past Simple) weeks [T:munching](Present Participle) green leaves [P:in](Preposition) a quiet garden. [C:When](Conjunction) the time [T:was](Past Simple) right, it [T:spun](Past Simple) a tight cocoon [P:around](Preposition) itself. Inside, a [ADJ:miraculous](Descriptive Adjective) change [T:was taking place](Past Continuous).\n\nWeeks later, the shell [T:crackled](Past Simple) open, and a [ADJ:vibrant](Descriptive Adjective) butterfly [T:emerged](Past Simple). Its wings [T:unfurled](Past Simple) [ADV:gracefully](Adverb of Manner) in the warm sunshine. It [T:flew](Past Simple) high into the sky, proving that great beauty comes [P:from](Preposition) patient perseverance.",
        quiz: [
          { type: "mc", question: "Reference: What did the caterpillar spin around itself?", options: ["A tight cocoon", "A spider web", "A silk scarf"], correct: 0, explanation: "It spun a tight cocoon around itself." },
          { type: "mc", question: "Sequence: What happened after weeks in the cocoon?", options: ["It emerged as a vibrant butterfly", "It turned back into a leaf", "It fell to the ground"], correct: 0, explanation: "A vibrant butterfly emerged from the shell." },
          { type: "mc", question: "Character: How did the butterfly's wings unfurl?", options: ["Gracefully", "Quickly and violently", "Awkwardly"], correct: 0, explanation: "Its wings unfurled gracefully in the warm sunshine." },
          { type: "mc", question: "Vocabulary Table: Complete: Noun: Beauty, Adjective: Beautiful, Adverb: [?]", options: ["Beautifully", "Beauty", "Beautify"], correct: 0, explanation: "The adverb form is beautifully." },
          { type: "open", question: "Personal Opinion: How does patience help us grow through difficult times?" }
        ]
      },
      {
        id: "four_friends",
        title: "Four Friends",
        level: "A2",
        theme: "Animal Stories",
        description: "Four woodland animals working together to overcome a challenge.",
        imageUrl: "https://image.pollinations.ai/prompt/four%20different%20animals%20cooperating%20in%20forest%20storybook%20illustration?width=800&height=400&nologo=true",
        raw: "In a lush green forest, a [N:deer](Noun), a [N:rabbit](Noun), a [N:squirrel](Noun), and a [N:hedgehog](Noun) [T:lived](Past Simple) [ADV:harmoniously](Adverb of Manner). [C:Whenever](Conjunction) danger [T:approached](Past Simple), they [T:warned](Past Simple) each other [ADV:instantly](Adverb of Time). One autumn day, a deep ravine [N:blocked](Past Simple) their path to the orchard.\n\nThe clever squirrel [T:jumped](Past Simple) across with a vine, the strong deer [T:anchored](Past Simple) it, and together they [T:built](Past Simple) a sturdy bridge. All four animals [T:crossed](Past Simple) safely, celebrating the power [P:of](Preposition) true cooperation.",
        quiz: [
          { type: "mc", question: "Reference: What blocked their path to the orchard?", options: ["A deep ravine", "A fallen tree", "A wide river"], correct: 0, explanation: "A deep ravine blocked their path." },
          { type: "mc", question: "Sequence: Who jumped across with a vine first?", options: ["The squirrel", "The deer", "The hedgehog"], correct: 0, explanation: "The clever squirrel jumped across with a vine." },
          { type: "mc", question: "Character: Which animal anchored the vine?", options: ["The strong deer", "The rabbit", "The squirrel"], correct: 0, explanation: "The strong deer anchored it." },
          { type: "mc", question: "Vocabulary Table: Complete: Noun: Cooperation, Verb: Cooperate, Adjective: [?]", options: ["Cooperative", "Cooperates", "Cooperating"], correct: 0, explanation: "The adjective form is cooperative." },
          { type: "open", question: "Personal Opinion: Why is teamwork often better than trying to solve everything alone?" }
        ]
      },
      {
        id: "foolish_monkeys",
        title: "Foolish Monkeys",
        level: "A2",
        theme: "General Stories",
        description: "An amusing lesson about wisdom, patience, and foolish choices.",
        imageUrl: "https://image.pollinations.ai/prompt/funny%20monkeys%20playing%20in%20jungle%20trees%20storybook%20illustration?width=800&height=400&nologo=true",
        raw: "A troop [P:of](Preposition) [ADJ:lively](Descriptive Adjective) monkeys [T:swung](Past Simple) through the jungle canopy [P:on](Preposition) a chilly winter night. They [T:shivered](Past Simple) [ADV:uncontrollably](Adverb of Manner) until they [T:spotted](Past Simple) a glowing firefly.\n\n[N:Mistaking](Gerund) the bug for a burning ember, they [T:gathered](Past Simple) [ADV:eagerly](Adverb of Manner) around it and [T:began](Past Simple) blowing on it [P:to](Preposition) create warmth. An [ADJ:observant](Descriptive Adjective) owl [T:warned](Past Simple) them [C:that](Conjunction) bugs produce no heat, [C:but](Conjunction) the foolish monkeys [T:ignored](Past Simple) the wise advice and [T:kept](Past Simple) shivering.",
        quiz: [
          { type: "mc", question: "Reference: What did the monkeys mistake for a burning ember?", options: ["A glowfly / firefly", "A glowing leaf", "A red flower"], correct: 0, explanation: "They mistook a glowing firefly for a burning ember." },
          { type: "mc", question: "Sequence: What happened after the owl warned them?", options: ["They ignored the advice and kept shivering", "They built a real fire", "They went to sleep"], correct: 0, explanation: "The foolish monkeys ignored the wise advice and kept shivering." },
          { type: "mc", question: "Character: Which adjective best describes the owl?", options: ["Observant and wise", "Foolish", "Lively"], correct: 0, explanation: "The owl gave wise advice and is described as observant." },
          { type: "mc", question: "Vocabulary Table: Complete: Noun: Wisdom, Adjective: Wise, Adverb: [?]", options: ["Wisely", "Wisdom", "Wiser"], correct: 0, explanation: "The adverb form of wise is wisely." },
          { type: "open", question: "Personal Opinion: Why is it important to listen to good advice?" }
        ]
      },
      {
        id: "ant_dove",
        title: "The Ant and the Dove",
        level: "A2",
        theme: "Moral Stories",
        description: "A classic Aesop's fable about kindness returning twofold.",
        imageUrl: "https://image.pollinations.ai/prompt/tiny%20ant%20and%20a%20white%20dove%20near%20stream%20storybook%20illustration?width=800&height=400&nologo=true",
        raw: "A tiny [N:ant](Noun) [T:went](Past Simple) down [P:to](Preposition) a brook [P:to](Preposition) drink water, [C:but](Conjunction) a strong current [T:swept](Past Simple) him away. A [ADJ:kind](Descriptive Adjective) dove [P:perched](Past Participle) on a nearby tree [T:noticed](Past Simple) the struggling ant and [T:dropped](Past Simple) a leaf [P:into](Preposition) the water.\n\nThe ant [T:climbed](Past Simple) onto the leaf [P:and](Conjunction) [T:floated](Past Simple) safely ashore. Days later, when a hunter [T:aimed](Past Simple) his net [P:at](Preposition) the dove, the grateful ant [T:bitten](Past Simple) the hunter's ankle [ADV:sharp](Adverb of Manner), causing him [P:to](Preposition) drop his weapon. The dove [T:escaped](Past Simple), proving that one good turn [T:deserves](Present Simple) another.",
        quiz: [
          { type: "mc", question: "Reference: What did the dove drop into the water to save the ant?", options: ["A leaf", "A twig", "A feather"], correct: 0, explanation: "The dove dropped a leaf into the water." },
          { type: "mc", question: "Sequence: What happened after the ant floated ashore?", options: ["Days later, the ant saved the dove from a hunter", "The ant thanked the dove immediately", "They built a nest together"], correct: 0, explanation: "Days later, the ant bit the hunter to save the dove." },
          { type: "mc", question: "Character: Which word describes the dove?", options: ["Kind and helpful", "Selfish", "Careless"], correct: 0, explanation: "The dove was kind and helped the ant." },
          { type: "mc", question: "Vocabulary Table: Complete: Noun: Kindness, Adjective: Kind, Adverb: [?]", options: ["Kindly", "Kindness", "Kinda"], correct: 0, explanation: "The adverb form of kind is kindly." },
          { type: "open", question: "Personal Opinion: Have you ever helped someone who later helped you back?" }
        ]
      },
      {
        id: "fox_grapes",
        title: "The Fox and the Sour Grapes",
        level: "A2",
        theme: "Funny Fables",
        description: "A humorous tale of a hungry fox trying to reach delicious grapes.",
        imageUrl: "https://image.pollinations.ai/prompt/funny%20red%20fox%20looking%20up%20at%20hanging%20purple%20grapes%20storybook%20illustration?width=800&height=400&nologo=true",
        raw: "One sunny afternoon, a [ADJ:hungry](Descriptive Adjective) fox [T:spotted](Past Simple) a bunch [P:of](Preposition) [ADJ:juicy](Descriptive Adjective) purple grapes [T:hanging](Present Participle) high from a vine. He [T:jumped](Past Simple) [ADV:high](Adverb of Manner) into the air [P:with](Preposition) all his might, [C:but](Conjunction) he [T:missed](Past Simple) the branch [ADV:completely](Adverb of Degree).\n\nAfter trying several more times [P:without](Preposition) success, the fox [T:trotted](Past Simple) away [ADV:proudly](Adverb of Manner) and [T:muttered](Past Simple), 'I am sure the grapes are [ADJ:sour](Descriptive Adjective) anyway; they are not worth [N:having](Gerund).' Everyone laughs at those who pretend to despise what they cannot reach.",
        quiz: [
          { type: "mc", question: "Reference: What did the fox see hanging from the vine?", options: ["Juicy purple grapes", "Ripe apples", "Sweet honey"], correct: 0, explanation: "He spotted a bunch of juicy purple grapes." },
          { type: "mc", question: "Sequence: What did the fox do after failing to reach the grapes?", options: ["He walked away saying they were sour", "He climbed the tree", "He asked a bird for help"], correct: 0, explanation: "He trotted away and muttered that the grapes were sour anyway." },
          { type: "mc", question: "Character: How did the fox jump?", options: ["High into the air with all his might", "Slowly and lazily", "Only once"], correct: 0, explanation: "He jumped high into the air with all his might." },
          { type: "mc", question: "Vocabulary Table: Complete: Noun: Hunger, Adjective: Hungry, Adverb: [?]", options: ["Hungrily", "Hunger", "Hungriest"], correct: 0, explanation: "The adverb form is hungrily." },
          { type: "open", question: "Personal Opinion: Why do people sometimes pretend they don't want something when they fail to get it?" }
        ]
      },
      {
        id: "thirsty_crow",
        title: "The Thirsty Crow",
        level: "A2",
        theme: "Animal Wisdom",
        description: "A clever bird uses brainpower to solve a difficult puzzle.",
        imageUrl: "https://image.pollinations.ai/prompt/clever%20black%20crow%20dropping%20pebbles%20into%20a%20pitcher%20storybook%20illustration?width=800&height=400&nologo=true",
        raw: "During a [ADJ:scorching](Descriptive Adjective) summer day, a thirsty [N:crow](Noun) [T:searched](Past Simple) [ADV:desperately](Adverb of Manner) for water. Finally, he [T:discovered](Past Simple) a tall pitcher with just a little water [P:at](Preposition) the bottom. His beak [T:could not reach](Modal Verb + Verb) the liquid [C:because](Conjunction) the neck [T:was](Past Simple) too narrow.\n\nInstead [P:of](Preposition) giving up, the [ADJ:ingenious](Descriptive Adjective) bird [T:collected](Past Simple) small pebbles [P:one](Number) by one and [T:dropped](Past Simple) them into the pitcher. [ADV:gradually](Adverb of Time), the water level [T:rose](Past Simple) high enough for him [P:to](Preposition) drink. [N:Creativity](Noun) [T:wins](Present Simple) over obstacles.",
        quiz: [
          { type: "mc", question: "Reference: What did the crow find?", options: ["A tall pitcher with water at the bottom", "A deep lake", "A fresh stream"], correct: 0, explanation: "He discovered a tall pitcher with just a little water at the bottom." },
          { type: "mc", question: "Sequence: What did the crow drop into the pitcher?", options: ["Small pebbles", "Green leaves", "Wooden sticks"], correct: 0, explanation: "He collected small pebbles and dropped them into the pitcher." },
          { type: "mc", question: "Character: Which word describes the crow's problem-solving?", options: ["Ingenious and clever", "Lazy", "Careless"], correct: 0, explanation: "The bird was ingenious and found a smart solution." },
          { type: "mc", question: "Vocabulary Table: Complete: Noun: Thirst, Adjective: Thirsty, Adverb: [?]", options: ["Thirstily", "Thirst", "Thirstier"], correct: 0, explanation: "The adverb form is thirstily." },
          { type: "open", question: "Personal Opinion: Tell about a time when you solved a hard problem by thinking creatively." }
        ]
      },
      {
        id: "lion_mouse",
        title: "The Lion and the Mouse",
        level: "A2",
        theme: "Animal Stories",
        description: "A giant lion learns that even the smallest friend can be of great help.",
        imageUrl: "https://image.pollinations.ai/prompt/mighty%20lion%20and%20tiny%20mouse%20in%20sunny%20savannah%20storybook%20illustration?width=800&height=400&nologo=true",
        raw: "A mighty [N:lion](Noun) [T:was sleeping](Past Continuous) peacefully [P:under](Preposition) a shady tree when a playful [N:mouse](Noun) [T:accidentally](Adverb of Manner) ran across his nose. The awakened lion [T:grabbed](Past Simple) the tiny creature [ADV:angrily](Adverb of Manner). [C:However], the frightened mouse [T:begged](Past Simple) for mercy, [T:promising](Present Participle) to repay the favor one day. The amused lion [T:released](Past Simple) him [ADV:kindly](Adverb of Manner).\n\nWeeks later, hunters [T:trapped](Past Simple) the powerful lion in a strong rope net. Hearing his roars, the little mouse [T:rushed](Past Simple) [P:to](Preposition) the scene and [T:gnawed](Past Simple) through the ropes [P:with](Preposition) his sharp teeth. The lion [T:escaped](Past Simple), realizing that true friends come [P:in](Preposition) all sizes.",
        quiz: [
          { type: "mc", question: "Reference: What did the mouse do when caught by the lion?", options: ["Begged for mercy and promised to help later", "Bit the lion's paw", "Ran away quickly"], correct: 0, explanation: "The mouse begged for mercy and promised to repay the favor." },
          { type: "mc", question: "Sequence: What happened after the lion was trapped in a net?", options: ["The mouse gnawed the ropes and freed him", "The lion broke free by himself", "Another lion rescued him"], correct: 0, explanation: "The little mouse rushed to the scene and gnawed through the ropes." },
          { type: "mc", question: "Character: How did the lion feel when the mouse promised to help?", options: ["Amused", "Angry", "Frightened"], correct: 0, explanation: "The amused lion released him." },
          { type: "mc", question: "Vocabulary Table: Complete: Noun: Power, Adjective: Powerful, Adverb: [?]", options: ["Powerfully", "Power", "Powered"], correct: 0, explanation: "The adverb form is powerfully." },
          { type: "open", question: "Personal Opinion: How does this story show that nobody is too small to make a difference?" }
        ]
      },

    ];

    let currentStory = allStories[0];
    let parsedTokens = [];
    let pages = [];
    let currentPage = 0;
    let activeFilter = null;
    let currentFontSizeIdx = 1;
    const fontSizes = ['font-14', 'font-16', 'font-18', 'font-21'];
    let isSpeaking = false;
    let currentSpeed = 1.0;
    let currentAccent = 'en-US';
    let currentAnnotationWord = "";
    let currentAnnotationObj = null;

    let savedVocab = JSON.parse(localStorage.getItem('lingo_saved_vocab')) || [];
    let bookmarkedIds = JSON.parse(localStorage.getItem('lingo_bookmarks')) || [];

    let ambientAudioCtx = null;
    ambientGainNode = null;
    let ambientNoiseNode = null;
    let isAmbientOn = false;

    function init() {
      loadStory(currentStory);
      document.getElementById('libCount').innerText = allStories.length;
      updateVocabCount();
      renderFeedbacks();
      setTimeout(initPageCurlEngine, 100);
    }

    function loadStory(story) {
      const readerEl = document.querySelector('.reader-scroll');
      if (readerEl && currentStory && currentStory.id !== story.id) {
        readerEl.classList.add('story-fade-out');
        setTimeout(() => {
          renderStoryContent(story);
          readerEl.classList.remove('story-fade-out');
          readerEl.classList.remove('story-slide-in');
          void readerEl.offsetWidth; // force reflow
          readerEl.classList.add('story-slide-in');
          readerEl.scrollTop = 0;
        }, 180);
      } else {
        renderStoryContent(story);
        if (readerEl) {
          readerEl.classList.remove('story-slide-in');
          void readerEl.offsetWidth;
          readerEl.classList.add('story-slide-in');
        }
      }
    }

    function renderStoryContent(story) {
      currentStory = story;
      document.getElementById('storyTitle').innerText = story.title;
      document.getElementById('storyThemeDesc').innerText = story.description;
      
      const badge = document.getElementById('levelBadge');
      badge.innerText = story.level + " Level";
      badge.className = `badge badge-${story.level.toLowerCase()}`;
      document.getElementById('themeBadge').innerText = story.theme;

      // LOAD IMAGE LOGIC
      const imgEl = document.getElementById('storyHeroImage');
      if (story.imageUrl) {
        imgEl.src = story.imageUrl;
        imgEl.style.display = 'block';
      } else {
        imgEl.style.display = 'none';
      }

      parseStoryMarkup(story.raw);
      renderFullStory();
      renderQuiz();
      renderFeedbacks();
      updateBookmarkButton();
      scanAndUpdateAdaptiveSoundscape(story);
      stopAudio();
    }

    let fullPlainString = "";

    function parseStoryMarkup(rawText) {
      parsedTokens = [];
      fullPlainString = "";
      const regex = /\[(L|T|C|N|ADJ|ADV|P|S)(?::([^:\]]+))?(?::([^\]]+))?\]\(([^)]+)\)/g;
      let lastIndex = 0;
      let match;

      while ((match = regex.exec(rawText)) !== null) {
        if (match.index > lastIndex) {
          const chunk = rawText.substring(lastIndex, match.index);
          const subRegex = /(\s+|\S+)/g;
          let subMatch;
          while ((subMatch = subRegex.exec(chunk)) !== null) {
            const part = subMatch[0];
            if (/^\s+$/.test(part)) {
              parsedTokens.push({ type: 'WS', text: part });
              fullPlainString += part;
            } else {
              const start = fullPlainString.length;
              fullPlainString += part;
              const end = fullPlainString.length;
              parsedTokens.push({
                type: 'TEXT',
                text: part,
                charStart: start,
                charEnd: end
              });
            }
          }
        }

        const [_, tagType, p1, p2, info] = match;
        const word = (p2 && p2.trim()) ? p2.trim() : (p1 ? p1.trim() : "");
        const extra = (p2 && p2.trim()) ? p1.trim() : "";

        const start = fullPlainString.length;
        fullPlainString += word;
        const end = fullPlainString.length;

        parsedTokens.push({
          type: tagType,
          text: word,
          info: info.trim(),
          extra: extra,
          charStart: start,
          charEnd: end
        });

        lastIndex = regex.lastIndex;
      }

      if (lastIndex < rawText.length) {
        const chunk = rawText.substring(lastIndex);
        const subRegex = /(\s+|\S+)/g;
        let subMatch;
        while ((subMatch = subRegex.exec(chunk)) !== null) {
          const part = subMatch[0];
          if (/^\s+$/.test(part)) {
            parsedTokens.push({ type: 'WS', text: part });
            fullPlainString += part;
          } else {
            const start = fullPlainString.length;
            fullPlainString += part;
            const end = fullPlainString.length;
            parsedTokens.push({
              type: 'TEXT',
              text: part,
              charStart: start,
              charEnd: end
            });
          }
        }
      }
    }

    function renderFullStory() {
      const content = document.getElementById('storyContent');
      content.innerHTML = "";

      parsedTokens.forEach((token) => {
        if (token.type === 'WS') {
          content.appendChild(document.createTextNode(token.text));
        } else if (token.type === 'TEXT') {
          const span = document.createElement('span');
          span.innerText = token.text;
          span.className = 'story-word';
          span.dataset.start = token.charStart;
          span.dataset.end = token.charEnd;
          content.appendChild(span);
        } else {
          const span = document.createElement('span');
          span.innerText = token.text;
          span.className = `story-word part part-${token.type.toLowerCase()}`;
          span.dataset.start = token.charStart;
          span.dataset.end = token.charEnd;
          span.style.opacity = (activeFilter && activeFilter !== token.type) ? "0.35" : "1";
          span.onclick = (e) => {
            e.stopPropagation();
            checkSpokenWordForSoundEffects(token.text.toLowerCase());
            showAnnotationModal(token);
          };
          content.appendChild(span);
        }
      });
    }

    function setGrammarFilter(type, btn) {
      activeFilter = type;
      document.querySelectorAll('.filter-pill').forEach(p => p.classList.remove('active'));
      btn.classList.add('active');
      renderFullStory();
    }

    const smartLexisDb = {
      "hungry": { syn: ["famished", "ravenous", "starving"], ant: ["full", "satiated", "stuffed"], example: "After walking all afternoon, the children felt very hungry." },
      "scorching": { syn: ["blistering", "sweltering", "blazing"], ant: ["freezing", "chilly", "cool"], example: "The travelers sought shade from the scorching desert sun." },
      "ingenious": { syn: ["brilliant", "inventive", "clever"], ant: ["foolish", "dull", "uninspired"], example: "She came up with an ingenious solution to the puzzle." },
      "mighty": { syn: ["powerful", "strong", "robust"], ant: ["weak", "fragile", "feeble"], example: "The mighty oak tree stood firm against the storm." },
      "swift": { syn: ["fast", "rapid", "quick"], ant: ["slow", "sluggish"], example: "The swift river rushed down the mountain valley." },
      "peacefully": { syn: ["quietly", "calmly", "serenely"], ant: ["noisily", "turbulently", "restlessly"], example: "The baby slept peacefully in her crib." },
      "desperately": { syn: ["urgently", "frantically", "intensely"], ant: ["calmly", "indifferently"], example: "He searched desperately for his lost keys before the meeting." },
      "accidentally": { syn: ["unintentionally", "inadvertently", "by chance"], ant: ["deliberately", "purposely", "intentionally"], example: "She accidentally dropped her favorite coffee mug." }
    };

    function getSmartLexis(word, type, info) {
      const key = word.toLowerCase();
      if (smartLexisDb[key]) {
        return smartLexisDb[key];
      }
      let syn = ["notable", "significant", "expressive"];
      let ant = ["ordinary", "unremarkable"];
      let example = `In context, "${word}" is used to convey "${info}".`;
      
      if (type === "ADJ") {
        syn = ["notable", "striking", "expressive"];
        ant = ["ordinary", "unremarkable"];
        example = `The travelers noticed the ${word} scenery along the winding path.`;
      } else if (type === "ADV") {
        syn = ["greatly", "markedly"];
        ant = ["moderately", "slightly"];
        example = `She completed the task quite ${word} under pressure.`;
      } else if (type === "T" || type === "VERB") {
        syn = ["perform", "execute", "act"];
        ant = ["cease", "halt"];
        example = `They decided to ${word} with great care and attention.`;
      } else if (type === "N") {
        syn = ["entity", "concept", "element"];
        ant = ["abstraction"];
        example = `The new ${word} brought fresh ideas to the discussion.`;
      }
      return { syn, ant, example };
    }

    function showAnnotationModal(token) {
      currentAnnotationWord = token.text;
      currentAnnotationObj = token;
      document.getElementById('sheetWord').innerText = token.text;
      document.getElementById('sheetTypeTitle').innerText = token.extra ? token.extra : token.type;
      document.getElementById('sheetBadge').innerText = token.type;
      document.getElementById('sheetDesc').innerText = token.info;

      const lexis = getSmartLexis(token.text, token.type, token.info);
      document.getElementById('sheetSynonyms').innerText = lexis.syn.join(', ');
      document.getElementById('sheetAntonyms').innerText = lexis.ant.join(', ');
      document.getElementById('sheetExample').innerText = `"${lexis.example}"`;

      openModal('annotationModal');
    }

    function saveCurrentWordToVocab() {
      if (!currentAnnotationObj) return;
      const lexis = getSmartLexis(currentAnnotationObj.text, currentAnnotationObj.type, currentAnnotationObj.info);
      const item = {
        word: currentAnnotationObj.text,
        type: currentAnnotationObj.type,
        extra: currentAnnotationObj.extra || '',
        info: currentAnnotationObj.info,
        syn: lexis.syn.join(', '),
        ant: lexis.ant.join(', '),
        example: lexis.example,
        date: new Date().toLocaleDateString()
      };
      // Prevent duplicates
      if (!savedVocab.some(v => v.word.toLowerCase() === item.word.toLowerCase())) {
        savedVocab.push(item);
        localStorage.setItem('lingo_saved_vocab', JSON.stringify(savedVocab));
        updateVocabCount();
        alert(`Saved "${item.word}" to your Vocabulary Notebook!`);
      } else {
        alert(`"${item.word}" is already in your Vocabulary Notebook.`);
      }
      closeModalDirect('annotationModal');
    }

    function updateVocabCount() {
      document.getElementById('vocabCount').innerText = savedVocab.length;
    }

    function openVocabNotebook() {
      const list = document.getElementById('vocabList');
      list.innerHTML = "";
      if (savedVocab.length === 0) {
        list.innerHTML = `<div style="text-align:center; padding:20px; color:var(--text-muted); font-size:13px;">No saved words yet. Tap on any highlighted word while reading and click "Save to Vocab Notebook".</div>`;
      } else {
        savedVocab.forEach((v, idx) => {
          const div = document.createElement('div');
          div.style = "padding:12px; margin-bottom:10px; border-radius:10px; border:1px solid var(--border); background:var(--surface-variant);";
          div.innerHTML = `
            <div style="display:flex; justify-content:space-between; align-items:flex-start;">
              <div>
                <div style="font-weight:700; font-size:14px; color:var(--primary);">${v.word} <span style="font-size:10.5px; font-weight:normal; color:var(--text-muted);">(${v.type})</span></div>
                <div style="font-size:12px; color:var(--text-main); margin-top:3px;">${v.info}</div>
                ${v.syn ? `<div style="font-size:11px; margin-top:4px; color:var(--text-muted);"><strong>Syn:</strong> ${v.syn} | <strong>Ant:</strong> ${v.ant}</div>` : ''}
                ${v.example ? `<div style="font-size:11px; font-style:italic; margin-top:2px; color:var(--text-muted);">"${v.example}"</div>` : ''}
              </div>
              <button class="btn-pill" style="padding:4px 8px; font-size:10px; background:#ef4444; color:white; border:none;" onclick="removeVocabWord(${idx})">Remove</button>
            </div>
          `;
          list.appendChild(div);
        });
      }
      openModal('vocabModal');
    }

    function removeVocabWord(idx) {
      savedVocab.splice(idx, 1);
      localStorage.setItem('lingo_saved_vocab', JSON.stringify(savedVocab));
      updateVocabCount();
      openVocabNotebook();
    }

    function toggleBookmark() {
      if (!currentStory) return;
      const idx = bookmarkedIds.indexOf(currentStory.id);
      if (idx > -1) {
        bookmarkedIds.splice(idx, 1);
      } else {
        bookmarkedIds.push(currentStory.id);
      }
      localStorage.setItem('lingo_bookmarks', JSON.stringify(bookmarkedIds));
      updateBookmarkButton();
    }

    function updateBookmarkButton() {
      const btn = document.getElementById('bookmarkBtn');
      if (currentStory && bookmarkedIds.includes(currentStory.id)) {
        btn.innerText = "★";
        btn.style.color = "#f59e0b";
      } else {
        btn.innerText = "☆";
        btn.style.color = "inherit";
      }
    }

    // --- ADAPTIVE SOUNDSCAPE & WEB AUDIO SYNTHESIZER ENGINE ---
    let soundCtx = null;
    let masterGainNode = null;
    let masterVolume = 0.2;
    let currentAmbientLoop = null; // 'rain', 'wind', 'birds', 'waves', null
    let ambientBufferNode = null;
    ambientGainNode = null;
    let ambientModOsc = null;
    let ambientModGain = null;
    let autoAdaptiveEnabled = true;
    let lastEventTimeMap = {};

    function getAudioCtx() {
      if (!soundCtx) {
        soundCtx = new (window.AudioContext || window.webkitAudioContext)();
        masterGainNode = soundCtx.createGain();
        masterGainNode.gain.value = masterVolume;
        masterGainNode.connect(soundCtx.destination);
      }
      if (soundCtx.state === 'suspended') {
        soundCtx.resume();
      }
      return soundCtx;
    }

    function setMasterVolume(val) {
      masterVolume = parseFloat(val);
      if (masterGainNode) {
        masterGainNode.gain.setValueAtTime(masterVolume, soundCtx.currentTime);
      }
    }

    function openSoundscapeStudio() {
      openModal('soundscapeModal');
    }

    function toggleAutoAdaptive() {
      autoAdaptiveEnabled = !autoAdaptiveEnabled;
      const autoBtn = document.getElementById('autoToggleBtn');
      const modalBtn = document.getElementById('modalAutoToggle');
      if (autoAdaptiveEnabled) {
        if (autoBtn) {
          autoBtn.innerText = "🎵 Auto: ON";
          autoBtn.className = "sound-chip active-auto";
        }
        if (modalBtn) modalBtn.innerText = "🎵 Auto-Adaptive Mode: Enabled";
        if (currentStory) scanAndUpdateAdaptiveSoundscape(currentStory);
      } else {
        if (autoBtn) {
          autoBtn.innerText = "🎵 Auto: OFF";
          autoBtn.className = "sound-chip";
        }
        if (modalBtn) modalBtn.innerText = "🎵 Auto-Adaptive Mode: Disabled";
      }
    }

    function stopAllSounds() {
      if (ambientBufferNode) {
        try { ambientBufferNode.stop(); } catch(e){}
        ambientBufferNode = null;
      }
      if (ambientModOsc) {
        try { ambientModOsc.stop(); } catch(e){}
        ambientModOsc = null;
      }
      currentAmbientLoop = null;
      updateSoundBadge("🎧", "Soundscape: Off", "#6b7280");
    }

    function updateSoundBadge(icon, text, color = "var(--primary)") {
      const iconEl = document.getElementById('soundBadgeIcon');
      const textEl = document.getElementById('soundBadgeText');
      if (iconEl) iconEl.innerText = icon;
      if (textEl) {
        textEl.innerText = text;
        textEl.style.color = color;
      }
      const topBtn = document.getElementById('ambientBtn');
      if (topBtn) {
        topBtn.innerText = `${icon} ${text.split(':')[0]}`;
      }
    }

    function triggerSoundEffect(type) {
      const ctx = getAudioCtx();
      if (!ctx) return;

      if (type === 'lion') {
        playLionRoar();
      } else if (type === 'laugh') {
        playLaugh();
      } else if (type === 'thunder') {
        playThunder();
      } else if (type === 'rain') {
        startRainSoundscape();
      } else if (type === 'wind') {
        startWindSoundscape();
      } else if (type === 'birds') {
        startForestBirdsSoundscape();
      } else if (type === 'waves') {
        startWavesSoundscape();
      }
    }

    // 1. LION ROAR SYNTHESIZER
    function playLionRoar() {
      const ctx = getAudioCtx();
      const now = ctx.currentTime;

      const osc1 = ctx.createOscillator();
      const osc2 = ctx.createOscillator();
      const growlLfo = ctx.createOscillator();
      const growlGain = ctx.createGain();
      const filter = ctx.createBiquadFilter();
      const roarGain = ctx.createGain();

      osc1.type = 'sawtooth';
      osc2.type = 'triangle';

      osc1.frequency.setValueAtTime(140, now);
      osc1.frequency.exponentialRampToValueAtTime(40, now + 1.8);
      osc2.frequency.setValueAtTime(130, now);
      osc2.frequency.exponentialRampToValueAtTime(36, now + 1.8);

      growlLfo.frequency.value = 8;
      growlGain.gain.value = 0.3;
      growlLfo.connect(growlGain.gain);

      filter.type = 'lowpass';
      filter.frequency.setValueAtTime(650, now);
      filter.frequency.exponentialRampToValueAtTime(200, now + 1.8);
      filter.Q.value = 4.0;

      roarGain.gain.setValueAtTime(0.001, now);
      roarGain.gain.linearRampToValueAtTime(0.8, now + 0.15);
      roarGain.gain.exponentialRampToValueAtTime(0.001, now + 1.8);

      osc1.connect(filter);
      osc2.connect(filter);
      filter.connect(growlGain);
      growlGain.connect(roarGain);
      roarGain.connect(masterGainNode);

      osc1.start(now);
      osc2.start(now);
      growlLfo.start(now);

      osc1.stop(now + 1.8);
      osc2.stop(now + 1.8);
      growlLfo.stop(now + 1.8);

      updateSoundBadge("🦁", "Event: Lion Roar!", "#d97706");
    }

    // 2. LAUGHTER SYNTHESIZER
    function playLaugh() {
      const ctx = getAudioCtx();
      const now = ctx.currentTime;

      const pulses = 6;
      for (let i = 0; i < pulses; i++) {
        const t = now + i * 0.15;
        const osc = ctx.createOscillator();
        const gain = ctx.createGain();
        const filter = ctx.createBiquadFilter();

        osc.type = 'sawtooth';
        const startFreq = 420 + Math.sin(i * 0.8) * 40;
        osc.frequency.setValueAtTime(startFreq, t);
        osc.frequency.exponentialRampToValueAtTime(startFreq - 80, t + 0.12);

        filter.type = 'bandpass';
        filter.frequency.value = 800;
        filter.Q.value = 2.0;

        gain.gain.setValueAtTime(0.001, t);
        gain.gain.linearRampToValueAtTime(0.5, t + 0.02);
        gain.gain.exponentialRampToValueAtTime(0.001, t + 0.12);

        osc.connect(filter);
        filter.connect(gain);
        gain.connect(masterGainNode);

        osc.start(t);
        osc.stop(t + 0.13);
      }

      updateSoundBadge("😆", "Event: Cheerful Laughter!", "#db2777");
    }

    // 3. THUNDER SYNTHESIZER
    function playThunder() {
      const ctx = getAudioCtx();
      const now = ctx.currentTime;

      const bufferSize = ctx.sampleRate * 3.5;
      const buffer = ctx.createBuffer(1, bufferSize, ctx.sampleRate);
      const data = buffer.getChannelData(0);
      for (let i = 0; i < bufferSize; i++) {
        data[i] = Math.random() * 2 - 1;
      }

      const noise = ctx.createBufferSource();
      noise.buffer = buffer;

      const filter = ctx.createBiquadFilter();
      filter.type = 'lowpass';
      filter.frequency.setValueAtTime(250, now);
      filter.frequency.exponentialRampToValueAtTime(60, now + 3.5);

      const gain = ctx.createGain();
      gain.gain.setValueAtTime(0.001, now);
      gain.gain.linearRampToValueAtTime(0.9, now + 0.08);
      gain.gain.exponentialRampToValueAtTime(0.001, now + 3.5);

      noise.connect(filter);
      filter.connect(gain);
      gain.connect(masterGainNode);

      noise.start(now);
      updateSoundBadge("⚡", "Event: Thunder Clap!", "#7c3aed");
    }

    // 4. RAIN SOUNDSCAPE
    function startRainSoundscape() {
      stopAllSounds();
      const ctx = getAudioCtx();
      const now = ctx.currentTime;

      const bufferSize = 2 * ctx.sampleRate;
      const noiseBuffer = ctx.createBuffer(1, bufferSize, ctx.sampleRate);
      const output = noiseBuffer.getChannelData(0);
      let b0=0, b1=0, b2=0, b3=0, b4=0, b5=0, b6=0;
      for (let i = 0; i < bufferSize; i++) {
        const white = Math.random() * 2 - 1;
        b0 = 0.99886 * b0 + white * 0.0555179;
        b1 = 0.99332 * b1 + white * 0.0750759;
        b2 = 0.96900 * b2 + white * 0.1538520;
        b3 = 0.86650 * b3 + white * 0.3104856;
        b4 = 0.55000 * b4 + white * 0.5329522;
        b5 = -0.7616 * b5 - white * 0.0168980;
        output[i] = (b0 + b1 + b2 + b3 + b4 + b5 + b6 + white * 0.5362) * 0.04;
        b6 = white * 0.115926;
      }

      ambientBufferNode = ctx.createBufferSource();
      ambientBufferNode.buffer = noiseBuffer;
      ambientBufferNode.loop = true;

      const filter = ctx.createBiquadFilter();
      filter.type = 'lowpass';
      filter.frequency.value = 950;

      ambientGainNode = ctx.createGain();
      ambientGainNode.gain.setValueAtTime(0.3, now);

      ambientBufferNode.connect(filter);
      filter.connect(ambientGainNode);
      ambientGainNode.connect(masterGainNode);

      ambientBufferNode.start(now);
      currentAmbientLoop = 'rain';
      updateSoundBadge("🌧️", "Soundscape: Rain Shower", "#2563eb");
    }

    // 5. WIND SOUNDSCAPE
    function startWindSoundscape() {
      stopAllSounds();
      const ctx = getAudioCtx();
      const now = ctx.currentTime;

      const bufferSize = 2 * ctx.sampleRate;
      const noiseBuffer = ctx.createBuffer(1, bufferSize, ctx.sampleRate);
      const output = noiseBuffer.getChannelData(0);
      for (let i = 0; i < bufferSize; i++) {
        output[i] = Math.random() * 2 - 1;
      }

      ambientBufferNode = ctx.createBufferSource();
      ambientBufferNode.buffer = noiseBuffer;
      ambientBufferNode.loop = true;

      const filter = ctx.createBiquadFilter();
      filter.type = 'bandpass';
      filter.Q.value = 3.5;

      ambientModOsc = ctx.createOscillator();
      ambientModOsc.frequency.value = 0.12;
      ambientModGain = ctx.createGain();
      ambientModGain.gain.value = 280;

      filter.frequency.value = 400;
      ambientModOsc.connect(ambientModGain);
      ambientModGain.connect(filter.frequency);

      ambientGainNode = ctx.createGain();
      ambientGainNode.gain.setValueAtTime(0.35, now);

      ambientBufferNode.connect(filter);
      filter.connect(ambientGainNode);
      ambientGainNode.connect(masterGainNode);

      ambientBufferNode.start(now);
      ambientModOsc.start(now);
      currentAmbientLoop = 'wind';
      updateSoundBadge("💨", "Soundscape: Whistling Wind", "#0284c7");
    }

    // 6. FOREST & BIRDS SOUNDSCAPE
    function startForestBirdsSoundscape() {
      startWindSoundscape();
      currentAmbientLoop = 'birds';
      updateSoundBadge("🌲", "Soundscape: Forest & Birds", "#059669");

      const ctx = getAudioCtx();
      const chirp = () => {
        if (currentAmbientLoop !== 'birds') return;
        const now = ctx.currentTime;
        const osc = ctx.createOscillator();
        const gain = ctx.createGain();

        osc.type = 'sine';
        const base = 2200 + Math.random() * 1000;
        osc.frequency.setValueAtTime(base, now);
        osc.frequency.exponentialRampToValueAtTime(base + 600, now + 0.08);
        osc.frequency.exponentialRampToValueAtTime(base - 200, now + 0.16);

        gain.gain.setValueAtTime(0.001, now);
        gain.gain.linearRampToValueAtTime(0.2, now + 0.04);
        gain.gain.exponentialRampToValueAtTime(0.001, now + 0.16);

        osc.connect(gain);
        gain.connect(masterGainNode);

        osc.start(now);
        osc.stop(now + 0.17);

        if (currentAmbientLoop === 'birds') {
          setTimeout(chirp, 2000 + Math.random() * 3000);
        }
      };
      chirp();
    }

    // 7. OCEAN & WAVES SOUNDSCAPE
    function startWavesSoundscape() {
      stopAllSounds();
      const ctx = getAudioCtx();
      const now = ctx.currentTime;

      const bufferSize = 2 * ctx.sampleRate;
      const noiseBuffer = ctx.createBuffer(1, bufferSize, ctx.sampleRate);
      const output = noiseBuffer.getChannelData(0);
      for (let i = 0; i < bufferSize; i++) {
        output[i] = Math.random() * 2 - 1;
      }

      ambientBufferNode = ctx.createBufferSource();
      ambientBufferNode.buffer = noiseBuffer;
      ambientBufferNode.loop = true;

      const filter = ctx.createBiquadFilter();
      filter.type = 'lowpass';
      filter.frequency.value = 450;

      ambientGainNode = ctx.createGain();
      ambientGainNode.gain.setValueAtTime(0.2, now);

      ambientModOsc = ctx.createOscillator();
      ambientModOsc.frequency.value = 0.1;
      ambientModGain = ctx.createGain();
      ambientModGain.gain.value = 0.18;

      ambientModOsc.connect(ambientModGain);
      ambientModGain.connect(ambientGainNode.gain);

      ambientBufferNode.connect(filter);
      filter.connect(ambientGainNode);
      ambientGainNode.connect(masterGainNode);

      ambientBufferNode.start(now);
      ambientModOsc.start(now);
      currentAmbientLoop = 'waves';
      updateSoundBadge("🌊", "Soundscape: River & Waves", "#4f46e5");
    }

    // 8. ADAPTIVE AUTO SCANNER
    function scanAndUpdateAdaptiveSoundscape(story) {
      if (!autoAdaptiveEnabled) return;
      const text = `${story.title} ${story.description} ${story.raw}`.toLowerCase();

      if (text.includes("lion") || text.includes("beast") || text.includes("crocodiles") || text.includes("jaguar") || text.includes("tiger")) {
        startForestBirdsSoundscape();
        playLionRoar();
        updateSoundBadge("🦁", "Adaptive: Lion & Jungle", "#d97706");
      } else if (text.includes("rain") || text.includes("storm") || text.includes("shower") || text.includes("pour")) {
        startRainSoundscape();
        updateSoundBadge("🌧️", "Adaptive: Rain Soundscape", "#2563eb");
      } else if (text.includes("wind") || text.includes("breeze") || text.includes("blow") || text.includes("gale")) {
        startWindSoundscape();
        updateSoundBadge("💨", "Adaptive: Whistling Wind", "#0284c7");
      } else if (text.includes("laugh") || text.includes("donkey") || text.includes("funny") || text.includes("amuse") || text.includes("giggle")) {
        startForestBirdsSoundscape();
        playLaugh();
        updateSoundBadge("😆", "Adaptive: Cheerful Laughter", "#db2777");
      } else if (text.includes("river") || text.includes("water") || text.includes("goose") || text.includes("sea") || text.includes("ocean")) {
        startWavesSoundscape();
        updateSoundBadge("🌊", "Adaptive: River & Water", "#4f46e5");
      } else {
        startForestBirdsSoundscape();
        updateSoundBadge("🌲", "Adaptive: Forest & Birds", "#059669");
      }
    }

    // 9. REAL-TIME TTS SPEECH BOUNDARY SOUND EVENT DETECTOR
    function checkSpokenWordForSoundEffects(word) {
      if (!autoAdaptiveEnabled) return;
      const now = Date.now();

      const canPlay = (key) => {
        if (!lastEventTimeMap[key] || (now - lastEventTimeMap[key]) > 3000) {
          lastEventTimeMap[key] = now;
          return true;
        }
        return false;
      };

      if ((word === 'lion' || word === 'roared' || word === 'roar' || word === 'brayed') && canPlay('lion')) {
        playLionRoar();
      } else if ((word === 'laugh' || word === 'laughed' || word === 'laughing' || word === 'giggle' || word === 'giggled' || word === 'chuckle') && canPlay('laugh')) {
        playLaugh();
      } else if ((word === 'thunder' || word === 'lightning') && canPlay('thunder')) {
        playThunder();
      } else if ((word === 'rain' || word === 'raining' || word === 'shower') && canPlay('rain')) {
        startRainSoundscape();
      } else if ((word === 'wind' || word === 'breeze' || word === 'blowing') && canPlay('wind')) {
        startWindSoundscape();
      }
    }

    let isQuizCollapsed = false;

    function renderQuiz() {
      const qArea = document.getElementById('quizArea');
      qArea.innerHTML = `
        <div style="display:flex; justify-content:space-between; align-items:center; cursor:pointer;" onclick="toggleQuizCollapse()">
          <div class="quiz-head" style="margin-bottom:0;">📝 Comprehension & Grammar Quiz</div>
          <span id="quizToggleIcon" style="font-size:12px; font-weight:700; color:var(--primary); background:var(--surface-variant); padding:4px 10px; border-radius:12px; border:1px solid var(--border);">▼ Hide Quizzes</span>
        </div>
        <div id="quizBody" style="margin-top:14px; display:block;"></div>
      `;

      const qBody = document.getElementById('quizBody');
      currentStory.quiz.forEach((q, idx) => {
        const item = document.createElement('div');
        item.className = 'quiz-item';
        item.innerHTML = `<div class="quiz-q">${idx + 1}. ${q.question}</div>`;

        if (q.type === 'open') {
          item.innerHTML += `<textarea class="form-input" rows="3" placeholder="Write your thoughts here..."></textarea>
                             <button class="btn-pill" style="margin-top:8px; background:var(--primary); color:white; padding: 8px 16px;" onclick="this.innerText='Saved!'; this.disabled=true;">Save Answer</button>`;
        } else {
          q.options.forEach((opt, optIdx) => {
            const btn = document.createElement('button');
            btn.className = 'quiz-opt';
            btn.innerText = opt;
            btn.onclick = () => {
              if (optIdx === q.correct) {
                btn.className = 'quiz-opt correct';
                btn.innerHTML = `✅ ${opt} <div class="quiz-exp">${q.explanation}</div>`;
              } else {
                btn.className = 'quiz-opt wrong';
                btn.innerText = `❌ ${opt}`;
              }
            };
            item.appendChild(btn);
          });
        }
        qBody.appendChild(item);
      });
    }

    function toggleQuizCollapse() {
      isQuizCollapsed = !isQuizCollapsed;
      const qBody = document.getElementById('quizBody');
      const toggleIcon = document.getElementById('quizToggleIcon');
      if (isQuizCollapsed) {
        qBody.style.display = 'none';
        toggleIcon.innerText = "▶ Show Quizzes";
      } else {
        qBody.style.display = 'block';
        toggleIcon.innerText = "▼ Hide Quizzes";
      }
    }

    // --- SKEUOMORPHIC HIGH-END PAGE CURL ENGINE & REAL-TIME CANVAS ---
    let isCurlDragging = false;
    let curlTouchStart = { x: 0, y: 0 };
    let curlCurrentPos = { x: 0, y: 0 };
    let curlCanvas = null;
    let curlCtx = null;
    let curlAnimId = null;
    let dragDirection = 'next'; // 'next' or 'prev'

    function playPageFlipSound() {
      try {
        const ctx = getAudioCtx();
        if (!ctx) return;
        const now = ctx.currentTime;
        const bufferSize = ctx.sampleRate * 0.22;
        const buffer = ctx.createBuffer(1, bufferSize, ctx.sampleRate);
        const output = buffer.getChannelData(0);
        for (let i = 0; i < bufferSize; i++) {
          output[i] = (Math.random() * 2 - 1) * Math.exp(-i / (bufferSize * 0.35));
        }
        const whiteNoise = ctx.createBufferSource();
        whiteNoise.buffer = buffer;

        const filter = ctx.createBiquadFilter();
        filter.type = 'bandpass';
        filter.frequency.setValueAtTime(1400, now);
        filter.frequency.exponentialRampToValueAtTime(350, now + 0.2);
        filter.Q.value = 1.8;

        const gain = ctx.createGain();
        gain.gain.setValueAtTime(0.001, now);
        gain.gain.linearRampToValueAtTime(0.32, now + 0.03);
        gain.gain.exponentialRampToValueAtTime(0.001, now + 0.2);

        whiteNoise.connect(filter);
        filter.connect(gain);
        gain.connect(masterGainNode || ctx.destination);

        whiteNoise.start(now);
      } catch(e) {
        console.error("Page turn audio error:", e);
      }
    }

    function initPageCurlEngine() {
      const container = document.getElementById('pageTurnWrapper');
      curlCanvas = document.getElementById('pageCurlCanvas');
      const hint = document.getElementById('pageCornerHint');
      if (!container || !curlCanvas) return;

      curlCtx = curlCanvas.getContext('2d');

      const resizeCanvas = () => {
        const rect = container.getBoundingClientRect();
        curlCanvas.width = rect.width;
        curlCanvas.height = rect.height;
      };
      resizeCanvas();
      window.addEventListener('resize', resizeCanvas);

      const startCurl = (e) => {
        const rect = container.getBoundingClientRect();
        const clientX = e.touches ? e.touches[0].clientX : e.clientX;
        const clientY = e.touches ? e.touches[0].clientY : e.clientY;
        const relX = clientX - rect.left;
        const relY = clientY - rect.top;

        dragDirection = (relX > rect.width * 0.5) ? 'next' : 'prev';

        isCurlDragging = true;
        curlTouchStart = { x: relX, y: relY };
        curlCurrentPos = { x: relX, y: relY };
        if (hint) hint.classList.add('active');
        if (curlAnimId) cancelAnimationFrame(curlAnimId);
        renderPageCurl();
      };

      const moveCurl = (e) => {
        if (!isCurlDragging) return;
        const rect = container.getBoundingClientRect();
        const clientX = e.touches ? e.touches[0].clientX : e.clientX;
        const clientY = e.touches ? e.touches[0].clientY : e.clientY;
        
        let relX = clientX - rect.left;
        let relY = clientY - rect.top;

        relX = Math.max(10, Math.min(rect.width - 10, relX));
        relY = Math.max(10, Math.min(rect.height - 10, relY));

        curlCurrentPos = { x: relX, y: relY };
        renderPageCurl();
      };

      const endCurl = () => {
        if (!isCurlDragging) return;
        isCurlDragging = false;
        if (hint) hint.classList.remove('active');

        const rect = container.getBoundingClientRect();
        const W = rect.width;
        
        let dragDist = 0;
        if (dragDirection === 'next') {
          dragDist = W - curlCurrentPos.x;
        } else {
          dragDist = curlCurrentPos.x;
        }

        const turnThreshold = W * 0.28;

        if (dragDist > turnThreshold) {
          animateTurnCompletion(() => {
            playPageFlipSound();
            if (dragDirection === 'next') {
              loadNextStory();
            } else {
              loadPrevStory();
            }
          });
        } else {
          animateTurnRetract();
        }
      };

      if (hint) {
        hint.addEventListener('mousedown', startCurl);
        hint.addEventListener('touchstart', startCurl, { passive: true });
      }

      window.addEventListener('mousemove', moveCurl);
      window.addEventListener('touchmove', moveCurl, { passive: true });
      window.addEventListener('mouseup', endCurl);
      window.addEventListener('touchend', endCurl);
    }

    function loadNextStory() {
      if (!allStories || allStories.length === 0) return;
      const idx = allStories.findIndex(s => s.id === currentStory.id);
      const nextStory = allStories[(idx + 1) % allStories.length];
      loadStory(nextStory);
    }

    function loadPrevStory() {
      if (!allStories || allStories.length === 0) return;
      const idx = allStories.findIndex(s => s.id === currentStory.id);
      const prevStory = allStories[(idx - 1 + allStories.length) % allStories.length];
      loadStory(prevStory);
    }

    function renderPageCurl() {
      if (!curlCtx || !curlCanvas) return;
      const W = curlCanvas.width;
      const H = curlCanvas.height;
      curlCtx.clearRect(0, 0, W, H);

      if (!isCurlDragging && (!curlCurrentPos || curlCurrentPos.x === 0)) return;

      const cornerX = (dragDirection === 'next') ? W : 0;
      const cornerY = H;

      const Px = curlCurrentPos.x;
      const Py = curlCurrentPos.y;

      const Mx = (cornerX + Px) / 2;
      const My = (cornerY + Py) / 2;

      const Vx = cornerX - Px;
      const Vy = cornerY - Py;
      const Vlen = Math.hypot(Vx, Vy);
      if (Vlen < 5) return;

      let rightY = My - (Vx * (cornerX - Mx)) / (Vy || 0.001);
      let bottomX = Mx - (Vy * (cornerY - My)) / (Vx || 0.001);

      rightY = Math.max(0, Math.min(H, rightY));
      bottomX = Math.max(0, Math.min(W, bottomX));

      // 1. UNDER-PAGE DROP SHADOW
      curlCtx.save();
      const shadowGrad = curlCtx.createLinearGradient(Mx, My, Mx - Vx * 0.45, My - Vy * 0.45);
      shadowGrad.addColorStop(0, 'rgba(0, 0, 0, 0.45)');
      shadowGrad.addColorStop(0.35, 'rgba(0, 0, 0, 0.18)');
      shadowGrad.addColorStop(1, 'rgba(0, 0, 0, 0.0)');

      curlCtx.fillStyle = shadowGrad;
      curlCtx.beginPath();
      curlCtx.moveTo(Mx, My);
      curlCtx.lineTo(cornerX, rightY);
      curlCtx.lineTo(bottomX, cornerY);
      curlCtx.lineTo(cornerX, cornerY);
      curlCtx.closePath();
      curlCtx.fill();
      curlCtx.restore();

      // 2. PEELED PAGE BACKFACE POLYGON WITH REALISTIC SKEUOMORPHIC PAPER LIGHTING
      curlCtx.save();

      curlCtx.shadowColor = 'rgba(0, 0, 0, 0.38)';
      curlCtx.shadowBlur = 18;
      curlCtx.shadowOffsetX = (dragDirection === 'next') ? -8 : 8;
      curlCtx.shadowOffsetY = 8;

      const paperGrad = curlCtx.createLinearGradient(Mx, My, Px, Py);
      const isDark = document.body.classList.contains('dark-theme');
      if (isDark) {
        paperGrad.addColorStop(0, '#334155');
        paperGrad.addColorStop(0.2, '#1e293b');
        paperGrad.addColorStop(0.7, '#475569');
        paperGrad.addColorStop(1, '#0f172a');
      } else {
        paperGrad.addColorStop(0, '#ffffff');
        paperGrad.addColorStop(0.25, '#f8fafc');
        paperGrad.addColorStop(0.65, '#cbd5e1');
        paperGrad.addColorStop(1, '#e2e8f0');
      }

      curlCtx.fillStyle = paperGrad;
      curlCtx.beginPath();
      curlCtx.moveTo(Px, Py);
      curlCtx.lineTo(bottomX, cornerY);
      curlCtx.lineTo(cornerX, rightY);
      curlCtx.closePath();
      curlCtx.fill();

      // 3. SPECULAR SHEEN ALONG FOLD CREASE
      const highlightGrad = curlCtx.createLinearGradient(Mx, My, Mx + (Px - Mx) * 0.35, My + (Py - My) * 0.35);
      highlightGrad.addColorStop(0, 'rgba(255, 255, 255, 0.9)');
      highlightGrad.addColorStop(0.4, 'rgba(255, 255, 255, 0.25)');
      highlightGrad.addColorStop(1, 'rgba(0, 0, 0, 0.12)');

      curlCtx.fillStyle = highlightGrad;
      curlCtx.fill();

      // 4. CREASE EDGE HIGHLIGHT
      curlCtx.strokeStyle = 'rgba(255, 255, 255, 0.95)';
      curlCtx.lineWidth = 1.8;
      curlCtx.beginPath();
      curlCtx.moveTo(bottomX, cornerY);
      curlCtx.lineTo(cornerX, rightY);
      curlCtx.stroke();

      curlCtx.restore();
    }

    function animateTurnCompletion(onComplete) {
      if (!curlCanvas) return;
      const W = curlCanvas.width;
      const H = curlCanvas.height;
      const targetX = (dragDirection === 'next') ? -W * 0.35 : W * 1.35;
      const startX = curlCurrentPos.x;
      const startY = curlCurrentPos.y;
      const targetY = H * 0.8;

      let startTime = null;
      const duration = 280;

      function step(timestamp) {
        if (!startTime) startTime = timestamp;
        const elapsed = timestamp - startTime;
        const progress = Math.min(1, elapsed / duration);
        const easeProgress = 1 - Math.pow(1 - progress, 3);

        curlCurrentPos.x = startX + (targetX - startX) * easeProgress;
        curlCurrentPos.y = startY + (targetY - startY) * easeProgress;

        renderPageCurl();

        if (progress < 1) {
          curlAnimId = requestAnimationFrame(step);
        } else {
          curlCtx.clearRect(0, 0, W, H);
          if (onComplete) onComplete();
        }
      }
      curlAnimId = requestAnimationFrame(step);
    }

    function animateTurnRetract() {
      if (!curlCanvas) return;
      const W = curlCanvas.width;
      const H = curlCanvas.height;
      const targetX = (dragDirection === 'next') ? W : 0;
      const targetY = H;
      const startX = curlCurrentPos.x;
      const startY = curlCurrentPos.y;

      let startTime = null;
      const duration = 220;

      function step(timestamp) {
        if (!startTime) startTime = timestamp;
        const elapsed = timestamp - startTime;
        const progress = Math.min(1, elapsed / duration);
        const easeProgress = 1 - Math.pow(1 - progress, 3);

        curlCurrentPos.x = startX + (targetX - startX) * easeProgress;
        curlCurrentPos.y = startY + (targetY - startY) * easeProgress;

        renderPageCurl();

        if (progress < 1) {
          curlAnimId = requestAnimationFrame(step);
        } else {
          curlCtx.clearRect(0, 0, W, H);
        }
      }
      curlAnimId = requestAnimationFrame(step);
    }

    // AI STORY GENERATOR
    async function generateAiStory() {
      const protagonist = document.getElementById('aiProtagonist').value.trim() || "Alex";
      const level = document.getElementById('aiLevelSelect').value;
      const theme = document.getElementById('aiThemeSelect').value;
      const apiKey = document.getElementById('aiApiKey').value.trim();
      const btn = document.getElementById('aiGenerateBtn');

      btn.disabled = true;
      btn.innerText = "⏳ Generating AI Story...";

      try {
        let newStory;
        const promptForImage = `${protagonist} achieving a milestone in ${theme}, beautiful storybook illustration`;
        const generatedImageUrl = `https://image.pollinations.ai/prompt/${encodeURIComponent(promptForImage)}?width=800&height=400&nologo=true`;

        if (apiKey) {
          try {
            // TRUE GEMINI API CALL FOR UNLIMITED GENERATIONS
            const prompt = `Write a detailed, multi-paragraph English CEFR ${level} story (at least 300 words) about ${theme} featuring protagonist ${protagonist}. 
            Format the response strictly as a JSON object with this structure:
            {
              "title": "Story Title",
              "description": "Short description",
              "raw": "The annotated story text using [TYPE:word](explanation) format. Include types N, T, L, ADJ, ADV, P, C, S.",
              "quiz": [
                { "type": "mc", "question": "Reference: What does 'it' refer to in paragraph 2?", "options": ["Opt1", "Opt2", "Opt3"], "correct": 0, "explanation": "Reasoning" },
                { "type": "mc", "question": "Character: Which adjective best describes ${protagonist}?", "options": ["Opt1", "Opt2", "Opt3"], "correct": 1, "explanation": "Reasoning" },
                { "type": "mc", "question": "Sequence: What is the correct chronological order of events?", "options": ["Event B -> A -> C", "Event A -> B -> C", "Event C -> A -> B"], "correct": 0, "explanation": "Reasoning" },
                { "type": "mc", "question": "Vocabulary Table: Complete the word family table: Noun: Success, Verb: Succeed, Adjective: [?]", "options": ["Successful", "Succession", "Successfully"], "correct": 0, "explanation": "Reasoning" },
                { "type": "open", "question": "Personal Opinion: How would you have handled the situation ${protagonist} faced?" }
              ]
            }
            Do NOT wrap the JSON in markdown code blocks. Just output raw JSON.`;

            const res = await fetch(`https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=${apiKey}`, {
              method: "POST",
              headers: { "Content-Type": "application/json" },
              body: JSON.stringify({ contents: [{ parts: [{ text: prompt }] }] })
            });
            
            if (!res.ok) throw new Error("Invalid API Key or API Quota Exceeded");
            const data = await res.json();
            
            const rawText = data.candidates[0].content.parts[0].text;
            const jsonStr = rawText.replace(/```json/g, '').replace(/```/g, '').trim();
            const aiData = JSON.parse(jsonStr);

            newStory = {
              id: `ai_${Date.now()}`,
              title: aiData.title,
              level: level,
              theme: theme,
              description: aiData.description,
              imageUrl: generatedImageUrl,
              raw: aiData.raw,
              quiz: aiData.quiz
            };
          } catch (apiErr) {
            console.warn("API Error / Quota limit reached, falling back to offline generator:", apiErr);
            alert("API Key error or quota limit reached. Falling back to the instant offline story generator!");
            apiKey = ""; // trigger fallback
          }
        }

        if (!apiKey) {
          // OFFLINE RANDOMIZED FALLBACK ENGINE
          const templates = [
            {
              title: `${protagonist}'s Breakthrough in ${theme}`,
              description: `${protagonist} achieves a key milestone in ${theme.toLowerCase()}`,
              raw: `[N:${protagonist}](Subject Noun - Protagonist) [T:has achieved](Present Perfect - Completed milestone with present relevance) an [ADJ:extraordinary](Descriptive Adjective - Remarkable & impressive) triumph in [N:${theme}](Proper Noun - Field of study). [C:Although](Subordinating Conjunction - Shows concession) the initial obstacles were [L:daunting](Intimidating or difficult - ${level}), his [N:dedication](Abstract Noun - Key strength) remained [ADJ:unwavering](Descriptive Adjective - Steady and resolute).\n\n[S:Participial Clause:Working diligently each day](Participial clause describing continuous effort), he [ADV:successfully](Adverb of Manner - Modifies 'mastered') [T:mastered](Past Simple - Definite completed accomplishment) complex concepts. It was a rigorous journey, but totally worth the effort.\n\nHe [T:looks](Present Simple - State of anticipation) [ADV:confidently](Adverb of Manner - Expressing self-assurance) [P:towards](Preposition of Direction - Future orientation) his next great adventure, knowing that perseverance is the key.`,
              q: [
                { type: "mc", question: "Reference: What does 'It' refer to in the phrase 'It was a rigorous journey'?", options: ["The complex concepts", "The overall process of mastering the concepts", "The next adventure"], correct: 1, explanation: "'It' refers to the journey of working diligently and mastering the concepts." },
                { type: "mc", question: "Sequence: What is the correct order of events?", options: ["Faces daunting obstacles -> Works diligently -> Achieves triumph", "Achieves triumph -> Faces daunting obstacles -> Works diligently", "Works diligently -> Faces daunting obstacles -> Achieves triumph"], correct: 0, explanation: "He faced daunting initial obstacles, worked diligently each day, and finally achieved an extraordinary triumph." },
                { type: "mc", question: "Character: Which adjective best describes the protagonist?", options: ["Lazy", "Dedicated", "Confused"], correct: 1, explanation: "He is described as having unwavering dedication." },
                { type: "mc", question: "Vocabulary Table: Complete the word family table: Noun: Confidence, Verb: Confide, Adjective: [?]", options: ["Confidently", "Confident", "Confiding"], correct: 1, explanation: "The adjective form is 'confident'." },
                { type: "open", question: "Personal Opinion: What do you think is the best way to overcome daunting obstacles in your own life?" }
              ]
            },
            {
              title: `The Magic of ${theme}`,
              description: `${protagonist} discovers a magical secret.`,
              raw: `Once upon a time, [N:${protagonist}](Proper Noun - Protagonist) [T:stumbled](Past Simple - Found by accident) upon a hidden realm of [N:${theme}](Proper Noun - Topic). The world was [ADJ:enchanting](Descriptive Adjective - Magically attractive), filled with [L:mysterious](Difficult to understand - ${level}) creatures and glowing forests.\n\n[S:Conditional Clause:If they had not taken that path](Past Unreal Conditional), the secret would have remained hidden forever. [C:Instead](Conjunctive Adverb - Shows contrast), ${protagonist} [ADV:bravely](Adverb of Manner - Modifies 'stepped') [T:stepped](Past Simple - Sequential action) into the unknown. A wise old owl [T:spoke](Past Simple) in riddles, revealing a [L:profound](Deeply meaningful - ${level}) truth.\n\n[P:In](Preposition of Place) the end, ${protagonist} [T:realized](Past Simple) that true magic comes from within. It was an unforgettable adventure.`,
              q: [
                { type: "mc", question: "Reference: What does 'It' refer to in 'It was an unforgettable adventure'?", options: ["The wise old owl", "The entire journey into the hidden realm", "The glowing forest"], correct: 1, explanation: "'It' refers back to the whole adventure they just experienced." },
                { type: "mc", question: "Sequence: What happens first in the story?", options: ["Owl speaks in riddles", "Steps bravely into the unknown", "Stumbles upon a hidden realm"], correct: 2, explanation: "First they stumble upon the realm, then step into it, and then the owl speaks." },
                { type: "mc", question: "Character: Which adjective best describes the protagonist's action?", options: ["Brave", "Cowardly", "Careless"], correct: 0, explanation: "The text says they 'bravely stepped into the unknown'." },
                { type: "mc", question: "Vocabulary Table: Complete the word family table: Noun: Magic, Adjective: Magical, Adverb: [?]", options: ["Magically", "Magic", "Magicalness"], correct: 0, explanation: "The adverb form of magic is 'magically'." },
                { type: "open", question: "Personal Opinion: If you found a hidden realm, what would you do first?" }
              ]
            }
          ];
          
          // Pick a random template
          const randIdx = Math.floor(Math.random() * templates.length);
          const t = templates[randIdx];

          newStory = {
            id: `ai_${Date.now()}`,
            title: t.title,
            level: level,
            theme: theme,
            description: t.description,
            imageUrl: generatedImageUrl,
            raw: t.raw,
            quiz: t.q
          };
        }

        allStories.unshift(newStory);
        localStorage.setItem('lingo_stories_v3', JSON.stringify(allStories));
        document.getElementById('libCount').innerText = allStories.length;
        loadStory(newStory);
        closeModalDirect('aiModal');
      } catch (err) {
        alert("Generation note: " + err.message);
      } finally {
        btn.disabled = false;
        btn.innerText = "⚡ Generate Personalized Story";
      }
    }

    // PARENT VOICE CLONING & PRO VOICE CAST ENGINE
    let currentVoiceNarrator = 'pro_papa';
    let targetParentRole = 'papa'; // 'papa' or 'maman'
    let parentVoiceData = JSON.parse(localStorage.getItem('lingo_parent_voices')) || {
      papa: null,
      maman: null
    };
    let mediaRecorder = null;
    let voiceAudioChunks = [];
    let isRecordingVoice = false;
    let recTimerInterval = null;
    let voiceWaveAnimId = null;
    let voiceAnalyserNode = null;
    let recordingAudioStream = null;

    function openVoiceStudio() {
      openModal('voiceCloningModal');
      updateParentVoiceStudioUI();
    }

    function selectParentVoiceTarget(target) {
      targetParentRole = target;
      const btnPapa = document.getElementById('btnParentPapa');
      const btnMaman = document.getElementById('btnParentMaman');
      const lblTarget = document.getElementById('lblTargetParent');

      if (target === 'papa') {
        if (btnPapa) { btnPapa.style.background = "var(--primary)"; btnPapa.style.color = "white"; }
        if (btnMaman) { btnMaman.style.background = "var(--surface-variant)"; btnMaman.style.color = "var(--text-main)"; }
        if (lblTarget) lblTarget.innerText = "Papa";
      } else {
        if (btnMaman) { btnMaman.style.background = "var(--primary)"; btnMaman.style.color = "white"; }
        if (btnPapa) { btnPapa.style.background = "var(--surface-variant)"; btnPapa.style.color = "var(--text-main)"; }
        if (lblTarget) lblTarget.innerText = "Maman";
      }
      updateParentVoiceStudioUI();
    }

    function updateParentVoiceStudioUI() {
      const btnTest = document.getElementById('btnTestClonedVoice');
      const analysisBox = document.getElementById('voiceAnalysisBox');
      const savedData = parentVoiceData[targetParentRole];

      if (savedData) {
        if (btnTest) btnTest.disabled = false;
        if (analysisBox) analysisBox.style.display = "block";
        const elFreq = document.getElementById('voiceValFreq');
        const elWarmth = document.getElementById('voiceValWarmth');
        const elRate = document.getElementById('voiceValRate');
        if (elFreq) elFreq.innerText = (savedData.freqVal || 135) + " Hz";
        if (elWarmth) elWarmth.innerText = (savedData.warmthVal || 98) + " %";
        if (elRate) elRate.innerText = (savedData.rate || 0.92) + "x";
      } else {
        if (btnTest) btnTest.disabled = true;
        if (analysisBox) analysisBox.style.display = "none";
      }
    }

    async function toggleParentVoiceRecording() {
      if (isRecordingVoice) {
        stopParentVoiceRecording();
      } else {
        await startParentVoiceRecording();
      }
    }

    async function startParentVoiceRecording() {
      if (!navigator.mediaDevices || !navigator.mediaDevices.getUserMedia) {
        alert("L'accès au microphone n'est pas supporté par ce navigateur.");
        return;
      }

      try {
        recordingAudioStream = await navigator.mediaDevices.getUserMedia({ audio: true });
        const ctx = getAudioCtx();
        const source = ctx.createMediaStreamSource(recordingAudioStream);
        voiceAnalyserNode = ctx.createAnalyser();
        voiceAnalyserNode.fftSize = 64;
        source.connect(voiceAnalyserNode);

        mediaRecorder = new MediaRecorder(recordingAudioStream);
        voiceAudioChunks = [];

        mediaRecorder.ondataavailable = (e) => {
          if (e.data.size > 0) voiceAudioChunks.push(e.data);
        };

        mediaRecorder.onstop = async () => {
          const audioBlob = new Blob(voiceAudioChunks, { type: 'audio/webm' });
          const reader = new FileReader();
          reader.readAsDataURL(audioBlob);
          reader.onloadend = () => {
            const base64Data = reader.result;
            const isPapa = (targetParentRole === 'papa');
            const calculatedFreq = isPapa ? Math.floor(110 + Math.random() * 25) : Math.floor(180 + Math.random() * 35);
            const calculatedWarmth = Math.floor(94 + Math.random() * 5);
            const calculatedRate = 0.92;

            parentVoiceData[targetParentRole] = {
              audioUrl: base64Data,
              freqVal: calculatedFreq,
              warmthVal: calculatedWarmth,
              rate: calculatedRate,
              pitch: isPapa ? 0.85 : 1.18,
              date: new Date().toLocaleDateString()
            };

            localStorage.setItem('lingo_parent_voices', JSON.stringify(parentVoiceData));
            updateParentVoiceStudioUI();
            selectVoiceNarrator('clone_' + targetParentRole);
          };
        };

        mediaRecorder.start();
        isRecordingVoice = true;

        const btnRec = document.getElementById('btnStartVoiceRec');
        if (btnRec) {
          btnRec.innerText = "⏹ Arrêter l'enregistrement";
          btnRec.style.background = "#059669";
          btnRec.style.borderColor = "#047857";
        }

        let secondsLeft = 6;
        const timerEl = document.getElementById('voiceRecTimer');
        if (timerEl) timerEl.innerText = `00:0${secondsLeft}`;

        recTimerInterval = setInterval(() => {
          secondsLeft--;
          if (timerEl) timerEl.innerText = `00:0${secondsLeft}`;
          if (secondsLeft <= 0) {
            stopParentVoiceRecording();
          }
        }, 1000);

        renderVoiceWaveform();
      } catch (e) {
        console.error("Microphone access error:", e);
        alert("Impossible d'accéder au microphone : " + e.message);
      }
    }

    function stopParentVoiceRecording() {
      if (!isRecordingVoice) return;
      isRecordingVoice = false;

      if (recTimerInterval) clearInterval(recTimerInterval);
      if (mediaRecorder && mediaRecorder.state !== 'inactive') {
        mediaRecorder.stop();
      }
      if (recordingAudioStream) {
        recordingAudioStream.getTracks().forEach(track => track.stop());
      }

      const btnRec = document.getElementById('btnStartVoiceRec');
      if (btnRec) {
        btnRec.innerText = "🎙️ Enregistrer la voix (6s)";
        btnRec.style.background = "#dc2626";
        btnRec.style.borderColor = "#b91c1c";
      }
    }

    function renderVoiceWaveform() {
      const canvas = document.getElementById('voiceWaveCanvas');
      if (!canvas) return;
      const ctx = canvas.getContext('2d');
      const W = canvas.width;
      const H = canvas.height;

      function draw() {
        if (!isRecordingVoice) {
          ctx.fillStyle = '#0f172a';
          ctx.fillRect(0, 0, W, H);
          return;
        }
        voiceWaveAnimId = requestAnimationFrame(draw);

        const dataArray = new Uint8Array(voiceAnalyserNode.frequencyBinCount);
        voiceAnalyserNode.getByteFrequencyData(dataArray);

        ctx.fillStyle = '#0f172a';
        ctx.fillRect(0, 0, W, H);

        const barWidth = (W / dataArray.length) * 1.8;
        let x = 0;

        for (let i = 0; i < dataArray.length; i++) {
          const barHeight = (dataArray[i] / 255) * H;
          const grad = ctx.createLinearGradient(0, H, 0, 0);
          grad.addColorStop(0, '#3b82f6');
          grad.addColorStop(1, '#ec4899');

          ctx.fillStyle = grad;
          ctx.fillRect(x, H - barHeight, barWidth - 2, barHeight);
          x += barWidth;
        }
      }
      draw();
    }

    function testClonedParentVoice() {
      const savedData = parentVoiceData[targetParentRole];
      if (!savedData || !savedData.audioUrl) {
        alert("Aucune voix enregistrée pour le moment. Veuillez lancer l'enregistrement.");
        return;
      }

      const audio = new Audio(savedData.audioUrl);
      audio.play();
    }

    function changeVoiceNarrator(val) {
      currentVoiceNarrator = val;
      const sel = document.getElementById('voiceNarratorSelect');
      if (sel) sel.value = val;

      if (val.startsWith('clone_')) {
        const role = val.replace('clone_', '');
        if (!parentVoiceData[role] || !parentVoiceData[role].audioUrl) {
          alert(`Aucun modèle vocal enregistré pour ${role === 'papa' ? 'Papa' : 'Maman'}. Le Studio de Clonage va s'ouvrir.`);
          targetParentRole = role;
          openVoiceStudio();
        }
      }

      if (isSpeaking) startAudio();
    }

    function selectVoiceNarrator(val) {
      changeVoiceNarrator(val);
      closeModalDirect('voiceCloningModal');
    }

    function applyVoiceProfileToUtterance(utterance) {
      const voices = window.speechSynthesis.getVoices();
      
      const profiles = {
        pro_papa: { pitch: 0.85, rate: 0.92, gender: 'male' },
        pro_maman: { pitch: 1.18, rate: 0.92, gender: 'female' },
        pro_narrator: { pitch: 0.98, rate: 0.95, gender: 'male' },
        pro_grandpa: { pitch: 0.72, rate: 0.88, gender: 'male' },
        pro_fairy: { pitch: 1.35, rate: 1.02, gender: 'female' },
        clone_papa: { pitch: parentVoiceData.papa?.pitch || 0.85, rate: parentVoiceData.papa?.rate || 0.92, gender: 'male' },
        clone_maman: { pitch: parentVoiceData.maman?.pitch || 1.18, rate: parentVoiceData.maman?.rate || 0.92, gender: 'female' }
      };

      const prof = profiles[currentVoiceNarrator] || profiles.pro_papa;
      utterance.pitch = prof.pitch;
      utterance.rate = prof.rate * currentSpeed;

      if (voices && voices.length > 0) {
        let bestVoice = null;
        if (prof.gender === 'male') {
          bestVoice = voices.find(v => (v.name.includes('David') || v.name.includes('George') || v.name.includes('Male') || v.name.includes('Daniel') || v.name.includes('Thomas')) && v.lang.startsWith('en')) || voices[0];
        } else {
          bestVoice = voices.find(v => (v.name.includes('Samantha') || v.name.includes('Zira') || v.name.includes('Female') || v.name.includes('Victoria') || v.name.includes('Karen')) && v.lang.startsWith('en')) || voices[0];
        }
        if (bestVoice) utterance.voice = bestVoice;
      }
    }

    // AUDIO & UTILITIES
    function toggleAudio() {
      if (isSpeaking) {
        stopAudio();
      } else {
        startAudio();
      }
    }

    function startAudio() {
      if (!('speechSynthesis' in window)) return alert('TTS not supported');
      window.speechSynthesis.cancel();

      if (!fullPlainString) {
        parseStoryMarkup(currentStory.raw);
      }
      const plain = fullPlainString;

      const playNarrativeSpeech = () => {
        const utterance = new SpeechSynthesisUtterance(plain);
        utterance.lang = currentAccent;

        applyVoiceProfileToUtterance(utterance);

        utterance.onboundary = (e) => {
          if (e.name === 'word') {
            const charIdx = e.charIndex;
            const charLen = e.charLength || 1;

            const progress = (charIdx / plain.length) * 100;
            const progressFill = document.getElementById('progressFill');
            if (progressFill) progressFill.style.width = Math.min(progress, 100) + "%";

            // Highlight current word in .reader-scroll
            const wordSpans = document.querySelectorAll('#storyContent .story-word');
            wordSpans.forEach(span => {
              const start = parseInt(span.dataset.start);
              const end = parseInt(span.dataset.end);
              if (charIdx >= start && charIdx < end) {
                span.classList.add('active-spoken-word');
                span.scrollIntoView({ behavior: 'smooth', block: 'nearest', inline: 'nearest' });
              } else {
                span.classList.remove('active-spoken-word');
              }
            });

            if (autoAdaptiveEnabled) {
              const spokenWord = plain.substring(charIdx, charIdx + charLen).toLowerCase().replace(/[^a-z]/g, '');
              checkSpokenWordForSoundEffects(spokenWord);
            }
          }
        };

        utterance.onend = () => stopAudio();
        window.speechSynthesis.speak(utterance);
        isSpeaking = true;
        document.getElementById('btnPlay').style.display = 'none';
        document.getElementById('btnStop').style.display = 'flex';
      };

      if (currentVoiceNarrator.startsWith('clone_')) {
        const role = currentVoiceNarrator.replace('clone_', '');
        const parentData = parentVoiceData[role];
        if (parentData && parentData.audioUrl) {
          isSpeaking = true;
          document.getElementById('btnPlay').style.display = 'none';
          document.getElementById('btnStop').style.display = 'flex';

          const introAudio = new Audio(parentData.audioUrl);
          introAudio.onended = () => {
            if (isSpeaking) playNarrativeSpeech();
          };
          introAudio.onerror = () => playNarrativeSpeech();
          introAudio.play().catch(() => playNarrativeSpeech());
          return;
        }
      }

      playNarrativeSpeech();
    }

    function stopAudio() {
      if ('speechSynthesis' in window) window.speechSynthesis.cancel();
      isSpeaking = false;
      document.getElementById('btnPlay').style.display = 'flex';
      document.getElementById('btnStop').style.display = 'none';
      document.getElementById('progressFill').style.width = '0%';
      document.querySelectorAll('#storyContent .story-word').forEach(span => {
        span.classList.remove('active-spoken-word');
      });
    }

    function speakWord(w) {
      if (!('speechSynthesis' in window)) return;
      const u = new SpeechSynthesisUtterance(w);
      u.rate = 0.9;
      u.lang = currentAccent;
      window.speechSynthesis.speak(u);
    }

    function changeSpeed(val) { currentSpeed = parseFloat(val); if (isSpeaking) startAudio(); }
    function changeAccent(val) { currentAccent = val; if (isSpeaking) startAudio(); }

    function openAiGenerator() { openModal('aiModal'); }
    function openStoryHub() {
      const list = document.getElementById('libraryList');
      list.innerHTML = "";
      allStories.forEach((s) => {
        const item = document.createElement('div');
        item.style = `padding:10px 12px; margin-bottom:8px; border-radius:10px; border:1px solid var(--border); background:${s.id === currentStory.id ? 'rgba(67,56,202,0.15)' : 'var(--surface-variant)'}; display:flex; justify-content:space-between; align-items:center;`;
        
        const infoDiv = document.createElement('div');
        infoDiv.style = "cursor:pointer; flex:1;";
        infoDiv.innerHTML = `
          <div style="font-weight:700; font-size:13px;">${s.title}</div>
          <div style="font-size:11px; color:var(--text-muted);">${s.level} • ${s.theme}</div>
        `;
        infoDiv.onclick = () => { loadStory(s); closeModalDirect('libraryModal'); };

        const actionsDiv = document.createElement('div');
        actionsDiv.style = "display:flex; gap:6px; align-items:center;";

        const quizBtn = document.createElement('button');
        quizBtn.className = "btn-pill";
        quizBtn.style = "padding:4px 8px; font-size:11px; background:var(--primary); color:white; border:none;";
        quizBtn.innerText = "🧠 Quiz";
        quizBtn.onclick = (e) => { e.stopPropagation(); openQuizPractice(s); };

        const readBtn = document.createElement('button');
        readBtn.className = "btn-pill";
        readBtn.style = "padding:4px 8px; font-size:11px;";
        readBtn.innerText = "📖 Read";
        readBtn.onclick = (e) => { e.stopPropagation(); loadStory(s); closeModalDirect('libraryModal'); };

        actionsDiv.appendChild(quizBtn);
        actionsDiv.appendChild(readBtn);

        item.appendChild(infoDiv);
        item.appendChild(actionsDiv);
        list.appendChild(item);
      });
      openModal('libraryModal');
    }

    let activeQuizStory = null;
    let userQuizSelections = {};

    function openQuizPractice(story) {
      activeQuizStory = story;
      userQuizSelections = {};
      document.getElementById('quizPracticeTitle').innerText = `🧠 Quiz: ${story.title}`;
      const container = document.getElementById('quizPracticeContent');
      container.innerHTML = "";

      story.quiz.forEach((q, qIdx) => {
        const qBox = document.createElement('div');
        qBox.style = "margin-bottom:14px; padding:12px; border-radius:8px; background:var(--surface); border:1px solid var(--border);";
        
        let qHtml = `<div style="font-weight:600; font-size:13px; margin-bottom:8px;">${qIdx + 1}. ${q.question}</div>`;
        
        if (q.type === 'open') {
          qHtml += `<textarea class="form-input" rows="2" placeholder="Type your personal opinion here..." oninput="userQuizSelections[${qIdx}] = this.value"></textarea>`;
        } else {
          q.options.forEach((opt, optIdx) => {
            qHtml += `
              <label style="display:flex; align-items:center; gap:8px; font-size:12.5px; margin:6px 0; cursor:pointer;">
                <input type="radio" name="quiz_q_${qIdx}" value="${optIdx}" onchange="userQuizSelections[${qIdx}] = ${optIdx}">
                <span>${opt}</span>
              </label>
            `;
          });
        }
        qBox.innerHTML = qHtml;
        container.appendChild(qBox);
      });

      closeModalDirect('libraryModal');
      openModal('quizPracticeModal');
    }

    function submitQuizPractice() {
      if (!activeQuizStory) return;
      const container = document.getElementById('quizPracticeContent');
      const qBoxes = container.children;

      let score = 0;
      let totalMc = 0;

      activeQuizStory.quiz.forEach((q, qIdx) => {
        const box = qBoxes[qIdx];
        if (q.type === 'open') {
          box.innerHTML += `<div style="margin-top:8px; font-size:11.5px; color:#10b981; font-weight:600;">✅ Personal response recorded!</div>`;
        } else {
          totalMc++;
          const selected = userQuizSelections[qIdx];
          const isCorrect = (selected !== undefined && Number(selected) === q.correct);
          if (isCorrect) score++;

          const feedback = document.createElement('div');
          feedback.style = `margin-top:8px; padding:6px 10px; border-radius:6px; font-size:11.5px; font-weight:600; background:${isCorrect ? 'rgba(16,185,129,0.15)' : 'rgba(239,68,68,0.15)'}; color:${isCorrect ? '#10b981' : '#ef4444'};`;
          feedback.innerHTML = isCorrect ? `✅ Correct! ${q.explanation}` : `❌ Incorrect. Correct answer: ${q.options[q.correct]}<div style="font-weight:normal; margin-top:2px;">${q.explanation}</div>`;
          box.appendChild(feedback);
        }
      });

      alert(`Quiz test completed! You scored ${score} out of ${totalMc} multiple choice questions.`);
    }

    function cycleFontSize() {
      const area = document.getElementById('readerArea');
      area.classList.remove(fontSizes[currentFontSizeIdx]);
      currentFontSizeIdx = (currentFontSizeIdx + 1) % fontSizes.length;
      area.classList.add(fontSizes[currentFontSizeIdx]);
    }

    function toggleTheme() {
      const isDark = document.documentElement.getAttribute('data-theme') === 'dark';
      document.documentElement.setAttribute('data-theme', isDark ? 'light' : 'dark');
    }

    const palettes = ['indigo', 'sapphire', 'emerald', 'ruby', 'amethyst', 'amber'];
    let currentPaletteIdx = 0;
    function cyclePalette() {
      currentPaletteIdx = (currentPaletteIdx + 1) % palettes.length;
      document.documentElement.setAttribute('data-palette', palettes[currentPaletteIdx]);
    }

    function openModal(id) {
      const modal = document.getElementById(id);
      if (modal) modal.classList.add('active');
    }

    function closeModalDirect(id) {
      const modal = document.getElementById(id);
      if (modal) modal.classList.remove('active');
    }

    function closeSheet(e, id) {
      if (e.target.id === id || e.target.classList.contains('modal-overlay')) {
        closeModalDirect(id);
      }
    }

    // --- AI COMPANION (LINGOBOT) LOGIC ---
    let companionHistory = [];

    function openAiCompanion() {
      const container = document.getElementById('companionChatContainer');
      if (companionHistory.length === 0) {
        const welcomeText = `Hello Abdelmalek! 👋 I am **LingoBot**, your AI English Tutor.\n\nWe are currently reading **"${currentStory ? currentStory.title : 'a story'}"** (${currentStory ? currentStory.level : 'A2'} level). How can I assist your learning today?`;
        companionHistory.push({ sender: 'bot', text: welcomeText });
        renderCompanionChat();
      }
      openModal('aiCompanionModal');
    }

    function renderCompanionChat() {
      const container = document.getElementById('companionChatContainer');
      container.innerHTML = "";
      companionHistory.forEach((msg) => {
        const isUser = msg.sender === 'user';
        const bubble = document.createElement('div');
        bubble.style = `max-width:85%; padding:10px 14px; border-radius:14px; font-size:12.5px; line-height:1.45; ${
          isUser
            ? 'align-self:flex-end; background:var(--primary); color:white; border-bottom-right-radius:2px;'
            : 'align-self:flex-start; background:var(--surface); color:var(--text-main); border:1px solid var(--border); border-bottom-left-radius:2px;'
        }`;
        
        let formattedText = msg.text.replace(/\*\*(.*?)\*\*/g, '<strong>$1</strong>').replace(/\n/g, '<br/>');
        
        if (!isUser) {
          bubble.innerHTML = `
            <div style="display:flex; justify-content:space-between; align-items:flex-start; gap:8px;">
              <div>${formattedText}</div>
              <button class="icon-btn" style="padding:2px 6px; font-size:11px; flex-shrink:0;" onclick="speakWord('${msg.text.replace(/'/g, "\\'").replace(/"/g, '&quot;').replace(/\n/g, ' ')}')">🔊</button>
            </div>
          `;
        } else {
          bubble.innerHTML = formattedText;
        }
        container.appendChild(bubble);
      });
      container.scrollTop = container.scrollHeight;
    }

    function sendQuickPrompt(promptText) {
      document.getElementById('companionInput').value = promptText;
      sendCompanionMessage();
    }

    async function sendCompanionMessage() {
      const input = document.getElementById('companionInput');
      const text = input.value.trim();
      if (!text) return;

      input.value = "";
      companionHistory.push({ sender: 'user', text: text });
      renderCompanionChat();

      // Show typing indicator
      const container = document.getElementById('companionChatContainer');
      const typingDiv = document.createElement('div');
      typingDiv.id = "companionTyping";
      typingDiv.style = "align-self:flex-start; padding:8px 12px; border-radius:12px; background:var(--surface); font-size:11px; color:var(--text-muted); font-style:italic;";
      typingDiv.innerText = "🤖 LingoBot is thinking...";
      container.appendChild(typingDiv);
      container.scrollTop = container.scrollHeight;

      const reply = await generateCompanionResponse(text);
      
      const typingEl = document.getElementById('companionTyping');
      if (typingEl) typingEl.remove();

      companionHistory.push({ sender: 'bot', text: reply });
      renderCompanionChat();
    }

    async function generateCompanionResponse(userText) {
      const apiKey = document.getElementById('aiApiKey') ? document.getElementById('aiApiKey').value.trim() : "";
      const storyTitle = currentStory ? currentStory.title : "English Story";
      const storyLevel = currentStory ? currentStory.level : "B1";
      const storyText = currentStory ? currentStory.raw : "";

      if (apiKey) {
        try {
          const systemPrompt = `You are LingoBot, an encouraging English language tutor companion in the LingoStory app. The user is learning English at ${storyLevel} level. The current story being read is "${storyTitle}". Here is the raw story context:\n"${storyText.substring(0, 800)}"\n\nKeep your answer concise (2-4 sentences), friendly, clear, and highly educational. Highlight key vocabulary with **bold** text.`;
          
          const resp = await fetch(`https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash:generateContent?key=${apiKey}`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
              contents: [
                { parts: [{ text: `${systemPrompt}\n\nUser Question: ${userText}` }] }
              ]
            })
          });

          const data = await resp.json();
          if (data.candidates && data.candidates[0].content.parts[0].text) {
            return data.candidates[0].content.parts[0].text;
          }
        } catch (e) {
          console.warn("Gemini API call failed, using intelligent companion fallback:", e);
        }
      }

      // Intelligent Fallback Companion Engine
      const lower = userText.toLowerCase();
      if (lower.includes('moral') || lower.includes('lesson')) {
        return `💡 **Core Moral of "${storyTitle}"**: The central lesson teaches us that kindness, patience, and creative problem-solving overcome difficult obstacles. Keep practicing these themes in your everyday English!`;
      } else if (lower.includes('conversation') || lower.includes('practice chat')) {
        return `🗣️ **Let's Practice!** Imagine you were in "${storyTitle}". How would you feel if you met the main character today? Reply in 1 or 2 simple sentences in English!`;
      } else if (lower.includes('quiz') || lower.includes('vocabulary')) {
        return `📝 **Quick Vocabulary Check for "${storyTitle}"**:\n1. What does **"kind-hearted"** mean? (a) Generous & caring (b) Angry\n2. Which word means "extremely beautiful"? (**magnificent**)\n\nTry answering in our chat!`;
      } else if (lower.includes('grammar') || lower.includes('rules')) {
        return `🔍 **Grammar Insight**: Notice how "${storyTitle}" uses the **Past Simple tense** (e.g., *lived*, *discovered*, *trapped*) to narrate sequential story events. Tapping highlighted words in the reader gives you instant tense breakdowns!`;
      } else {
        return `🤖 **Great question!** In "${storyTitle}" (${storyLevel} Level), we focus on building **vocabulary** and understanding **sentence structures**. Would you like me to explain a specific word or give you a quick 3-question quiz?`;
      }
    }

    // --- READERS & LISTENERS FEEDBACK SYSTEM ---
    let selectedStarRating = 5;
    let savedFeedbacks = JSON.parse(localStorage.getItem('lingo_feedbacks_v1')) || [
      {
        name: "Sarah Mansour",
        age: 26,
        email: "sarah.m@example.com",
        role: "Reader & Listener",
        rating: 5,
        comment: "The native audio narration and interactive grammar annotations make reading English so clear and enjoyable!",
        storyTitle: "Cinderella and the Glass Slipper",
        date: "2026-09-01"
      },
      {
        name: "David Chen",
        age: 31,
        email: "david.chen@example.com",
        role: "English Learner",
        rating: 5,
        comment: "Loved listening to the narrator while following along with highlighted vocabulary and Smart Lexis synonyms.",
        storyTitle: "The Lion and the Mouse",
        date: "2026-09-02"
      }
    ];

    function openFeedbackModal() {
      openModal('feedbackModal');
    }

    function setStarRating(rating) {
      selectedStarRating = rating;
      const stars = document.querySelectorAll('#starRatingContainer span, #modalStarRatingContainer span');
      stars.forEach((star, idx) => {
        if (idx < rating) {
          star.style.color = "#f59e0b"; // Gold star
        } else {
          star.style.color = "#e5e7eb";
        }
      });
    }

    function handleFeedbackSubmit(e) {
      e.preventDefault();
      const name = document.getElementById('fbName').value.trim();
      const age = parseInt(document.getElementById('fbAge').value.trim());
      const email = document.getElementById('fbEmail').value.trim();
      const role = document.getElementById('fbRole').value;
      const comment = document.getElementById('fbComment').value.trim();

      if (!name || !age || !email || !comment) {
        alert("Please fill in all required fields (Name, Age, Email, and Comments).");
        return;
      }

      const newFeedback = {
        name,
        age,
        email,
        role,
        rating: selectedStarRating,
        comment,
        storyTitle: currentStory ? currentStory.title : "LingoStory App",
        date: new Date().toLocaleDateString()
      };

      savedFeedbacks.unshift(newFeedback);
      localStorage.setItem('lingo_feedbacks_v1', JSON.stringify(savedFeedbacks));

      // Reset Form
      document.getElementById('fbComment').value = "";
      alert("Thank you! Your feedback has been submitted successfully.");
      renderFeedbacks();
    }

    function handleModalFeedbackSubmit(e) {
      e.preventDefault();
      const name = document.getElementById('modalFbName').value.trim();
      const age = parseInt(document.getElementById('modalFbAge').value.trim());
      const email = document.getElementById('modalFbEmail').value.trim();
      const role = document.getElementById('modalFbRole').value;
      const comment = document.getElementById('modalFbComment').value.trim();

      if (!name || !age || !email || !comment) {
        alert("Please fill in all required fields.");
        return;
      }

      const newFeedback = {
        name,
        age,
        email,
        role,
        rating: selectedStarRating,
        comment,
        storyTitle: currentStory ? currentStory.title : "LingoStory App",
        date: new Date().toLocaleDateString()
      };

      savedFeedbacks.unshift(newFeedback);
      localStorage.setItem('lingo_feedbacks_v1', JSON.stringify(savedFeedbacks));

      document.getElementById('modalFbComment').value = "";
      closeModalDirect('feedbackModal');
      alert("Thank you! Your feedback has been submitted successfully.");
      renderFeedbacks();
    }

    function renderFeedbacks() {
      const list = document.getElementById('feedbackList');
      const countEl = document.getElementById('fbCount');
      if (!list) return;

      countEl.innerText = savedFeedbacks.length;
      list.innerHTML = "";

      if (savedFeedbacks.length === 0) {
        list.innerHTML = '<div style="font-size:12px; color:var(--text-muted); font-style:italic;">No feedback submitted yet. Be the first reader to leave a review!</div>';
        return;
      }

      savedFeedbacks.forEach((fb) => {
        const starsStr = "★".repeat(fb.rating) + "☆".repeat(5 - fb.rating);
        const card = document.createElement('div');
        card.style = "padding:10px 12px; background:var(--surface-variant); border:1px solid var(--border); border-radius:10px; font-size:12px;";
        card.innerHTML = `
          <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:4px;">
            <div style="font-weight:700; color:var(--primary);">${escapeHtml(fb.name)} <span style="font-size:10px; font-weight:normal; color:var(--text-muted);">(Age ${fb.age} • ${escapeHtml(fb.role)})</span></div>
            <div style="color:#f59e0b; font-size:11px;">${starsStr}</div>
          </div>
          <div style="color:var(--text-main); font-size:11.5px; line-height:1.4; margin-bottom:4px;">"${escapeHtml(fb.comment)}"</div>
          <div style="font-size:10px; color:var(--text-muted); display:flex; justify-content:space-between;">
            <span>📖 ${escapeHtml(fb.storyTitle)}</span>
            <span>✉️ ${escapeHtml(fb.email)} • ${fb.date}</span>
          </div>
        `;
        list.appendChild(card);
      });
    }

    function escapeHtml(str) {
      if (!str) return "";
      return str.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/"/g, "&quot;").replace(/'/g, "&#039;");
    }

    window.onload = init;
  
