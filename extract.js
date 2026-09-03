889:  <script>
890-    // Initial stories featuring learner Alex and Classic Fairy Tales
891-    let allStories = JSON.parse(localStorage.getItem('lingo_stories_v5')) || [
892-      {
893-        id: "cinderella_1",
894-        title: "Cinderella and the Glass Slipper",
895-        level: "B1",
896-        theme: "Fairy Tale",
897-        description: "A classic tale of kindness, magic, and a lost shoe.",
898-        imageUrl: "https://image.pollinations.ai/prompt/Cinderella%20running%20away%20from%20castle%20leaving%20glass%20slipper%20storybook%20illustration?width=800&height=400&nologo=true",
899-        raw: "Once upon a time, there [T:lived](Past Simple - State of being) a [ADJ:kind-hearted](Descriptive Adjective - Compassionate) girl named [N:Cinderella](Proper Noun - Main character). She [T:was forced](Past Simple Passive - Action done to her) to work [ADV:endlessly](Adverb of Frequency - Without stopping) by her [ADJ:cruel](Descriptive Adjective - Mean) stepmother. [C:Despite](Preposition/Conjunction - Shows contrast) her difficult life, she [T:remained](Past Simple - Continued to be) [ADJ:hopeful](Descriptive Adjective - Full of hope).\n\nOne evening, the King [T:invited](Past Simple - Action of offering an invitation) everyone [P:to](Preposition of Direction) a royal ball. Cinderella [T:could not go](Modal Verb - Lack of ability) because she had no dress. [ADV:Suddenly](Adverb of Manner - Unexpectedly), her Fairy Godmother [T:appeared](Past Simple - Sudden action). With a wave of her [ADJ:magic](Descriptive Adjective) wand, she [T:transformed](Past Simple - Changed completely) a pumpkin into a [L:magnificent](Extremely beautiful - B1) carriage.\n\n\"You must return [P:by](Preposition of Time) midnight,\" the Godmother [T:warned](Past Simple - Gave a caution). At the ball, the Prince [T:was captivated](Past Simple Passive - Deeply attracted) by her. [C:However](Conjunctive Adverb - Shows contrast), when the clock [T:struck](Past Simple - Sounded) twelve, she [T:fled](Past Simple - Ran away quickly), leaving [P:behind](Preposition of Place) a single glass slipper. The Prince used it to find her, and they lived [ADV:happily](Adverb of Manner) ever after.",
900-        quiz: [
901-          { type: "mc", question: "Reference: What does 'it' refer to in the sentence 'The Prince used it to find her'?", options: ["The carriage", "The glass slipper", "The pumpkin"], correct: 1, explanation: "'It' refers back to the single glass slipper she left behind." },
902-          { type: "mc", question: "Sequence: What is the correct chronological order of events?", options: ["Godmother appears -> Cinderella goes to the ball -> Leaves slipper", "Leaves slipper -> Godmother appears -> Cinderella goes to the ball", "Cinderella goes to the ball -> Godmother appears -> Leaves slipper"], correct: 0, explanation: "First the Godmother transforms the pumpkin, then Cinderella attends the ball, and finally she flees leaving the slipper." },
903-          { type: "mc", question: "Character: Which adjective best describes the stepmother?", options: ["Cruel", "Kind-hearted", "Magnificent"], correct: 0, explanation: "The text explicitly states she was forced to work endlessly by her 'cruel' stepmother." },
904-          { type: "mc", question: "Vocabulary Table: Complete the word family table: Noun: Magic, Adjective: Magical, Adverb: [?]", options: ["Magicalness", "Magic", "Magically"], correct: 2, explanation: "The adverb form of magic is 'magically'." },
905-          { type: "open", question: "Personal Opinion: Do you think Cinderella should have forgiven her stepmother at the end?" }
906-        ]
907-      },
908-      {
909-        id: "red_riding_hood_1",
910-        title: "Little Red Riding Hood",
911-        level: "A2",
912-        theme: "Fairy Tale",
913-        description: "A young girl's journey through the forest to visit her grandmother.",
914-        imageUrl: "https://image.pollinations.ai/prompt/Little%20Red%20Riding%20Hood%20walking%20in%20a%20dark%20forest%20storybook%20illustration?width=800&height=400&nologo=true",
915-        raw: "[N:Little Red Riding Hood](Proper Noun - Main character) [T:was walking](Past Continuous - Ongoing action in the past) through the [ADJ:dark](Descriptive Adjective) forest to visit her sick [N:grandmother](Noun - Family member). She [T:carried](Past Simple - Action) a [L:basket](A container for carrying things - A2) full of sweet treats. [S:Relative Clause:While she was picking flowers](Dependent clause showing simultaneous action), a [ADJ:cunning](Descriptive Adjective - Clever and deceitful) wolf [T:approached](Past Simple - Moved closer) her.\n\n\"Where are you going?\" the wolf [T:asked](Past Simple) [ADV:slyly](Adverb of Manner - In a sneaky way). She [T:told](Past Simple) him the truth [C:because](Subordinating Conjunction - Shows reason) she was [ADJ:innocent](Descriptive Adjective - Naive or pure). The wolf [T:ran](Past Simple) ahead [P:to](Preposition of Direction) the cottage, intending to trick them.\n\n[ADV:Fortunately](Adverb of Evaluation - Luckily), a [ADJ:brave](Descriptive Adjective - Courageous) woodcutter [T:heard](Past Simple - Perceived sound) the noise and [T:rescued](Past Simple - Saved from danger) them just in time. Little Red Riding Hood [T:learned](Past Simple - Acquired knowledge) never to speak to strangers [P:in](Preposition of Place) the woods again.",
916-        quiz: [
917-          { type: "mc", question: "Reference: Who does 'him' refer to in the sentence 'She told him the truth'?", options: ["The woodcutter", "The wolf", "Her grandmother"], correct: 1, explanation: "'Him' refers to the cunning wolf she was talking to." },
918-          { type: "mc", question: "Sequence: What is the correct chronological order of events?", options: ["Meets wolf -> Wolf runs to cottage -> Woodcutter rescues them", "Woodcutter rescues them -> Meets wolf -> Wolf runs to cottage", "Wolf runs to cottage -> Meets wolf -> Woodcutter rescues them"], correct: 0, explanation: "She meets the wolf while picking flowers, the wolf runs ahead, and then the woodcutter saves them." },
919-          { type: "mc", question: "Character: Which adjective best describes the wolf?", options: ["Brave", "Innocent", "Cunning"], correct: 2, explanation: "The story specifically describes the wolf as 'cunning' and speaking 'slyly'." },
920-          { type: "mc", question: "Vocabulary Table: Complete the word family table: Noun: Innocence, Adjective: Innocent, Adverb: [?]", options: ["Innocently", "Innocent", "Innocents"], correct: 0, explanation: "The adverb form of innocent is 'innocently'." },
921-          { type: "open", question: "Personal Opinion: Why is it important to be careful when talking to strangers?" }
922-        ]
923-      },
924-      {
925-        id: "alex_journey_1",
926-        title: "Alex's First Journey to London",
927-        level: "A2",
928-        theme: "Travel",
929-        description: "Alex's first adventure exploring London",
930-        imageUrl: "https://image.pollinations.ai/prompt/London%20Big%20Ben%20travel%20illustration%20storybook?width=800&height=400&nologo=true",
931-        raw: "[N:Alex](Subject Noun - Main traveler) [T:wakes up](Present Simple - Routine & habit) [ADV:early](Adverb of Time - Modifies 'wakes up') today [C:because](Subordinating Conjunction - Explains cause) it is his [ADJ:first](Ordinal Adjective - Modifies 'day') day in [N:London](Proper Noun - Destination city). He [T:feels](Present Simple - Stative verb of emotion) a bit [L:nervous](Anxious or worried - A2) about navigating the underground, [C:but](Coordinating Conjunction - Shows contrast) his [N:enthusiasm](Abstract Noun - Key motivation) keeps him going.\n\nAfter a [L:hearty](Substantial and satisfying - A2) [N:breakfast](Concrete Noun - Morning meal) at a [ADJ:cozy](Descriptive Adjective - Warm & comfortable) local cafe, he decides to visit Big Ben. [S:Relative Clause:While he is waiting for the bus](Dependent temporal clause describing simultaneous actions), an [ADJ:elderly](Descriptive Adjective - Modifies 'lady') lady [ADV:kindly](Adverb of Manner - Modifies 'offers') offers directions. She [T:explains](Present Simple - General truth) the city route with great detail. \n\nAlex thanks her [ADV:warmly](Adverb of Manner - Expressing gratitude) [C:and](Coordinating Conjunction - Connects actions) walks [P:towards](Preposition of Direction - Indicates movement to destination) the station. He feels [L:confident](Feeling sure of oneself - A2) that this trip will be unforgettable. It is the beginning of a beautiful journey.",
932-        quiz: [
933-          { type: "mc", question: "Reference: What does 'it' refer to in the sentence 'It is the beginning of a beautiful journey'?", options: ["The bus", "The trip to London", "The breakfast"], correct: 1, explanation: "'It' refers back to the overall trip and experience he is having." },
934-          { type: "mc", question: "Sequence: What is the correct chronological order of events?", options: ["Wakes up -> Eats breakfast -> Waits for bus -> Thanks lady", "Eats breakfast -> Wakes up -> Waits for bus -> Thanks lady", "Waits for bus -> Wakes up -> Eats breakfast -> Thanks lady"], correct: 0, explanation: "Alex wakes up, then has a hearty breakfast, then waits for the bus, and finally thanks the elderly lady." },
935-          { type: "mc", question: "Character: Which adjective best describes the elderly lady?", options: ["Selfish", "Helpful", "Nervous"], correct: 1, explanation: "She is helpful because she kindly offers directions and explains the route in detail." },
936-          { type: "mc", question: "Vocabulary Table: Complete the word family table: Noun: Confidence, Verb: Confide, Adjective: [?]", options: ["Confidently", "Confidant", "Confident"], correct: 2, explanation: "The adjective form of confidence is 'confident'." },
937-          { type: "open", question: "Personal Opinion: Have you ever been nervous on a trip? How did you handle it?" }
938-        ]
939-      },
940-      {
941-        id: "treasure_hunt",
942-        title: "Treasure Hunt",
943-        level: "B1",
944-        theme: "Adventure Stories",
945-        description: "An exciting expedition to find a legendary island treasure.",
946-        imageUrl: "https://image.pollinations.ai/prompt/Treasure%20Hunt%20pirate%20map%20adventure%20storybook%20illustration?width=800&height=400&nologo=true",
947-        raw: "Captain [N:James](Proper Noun - Explorer) [T:discovered](Past Simple - Found) an [ADJ:ancient](Descriptive Adjective - Very old) parchment map [P:inside](Preposition of Place) a dusty chest. The map [T:pointed](Past Simple - Indicated) toward Whispering Island, a place [T:shrouded](Past Simple Passive - Covered) in mystery. [C:Although](Conjunctive - Contrast) the journey was [ADJ:treacherous](Descriptive Adjective - Dangerous), his crew sailed [ADV:bravely](Adverb of Manner) through the stormy seas.\n\nUpon [T:landing](Gerund - Arriving on shore), they followed three golden markers [P:past](Preposition of Position) the roaring waterfall. There, beneath the roots of an [ADJ:immense](Descriptive Adjective - Huge) banyan tree, they [T:uncovered](Past Simple - Revealed) the chest of gold. It was a victory to remember.",
948-        quiz: [
949-          { type: "mc", question: "Reference: What does 'The map' point toward?", options: ["Whispering Island", "A dusty chest", "A stormy sea"], correct: 0, explanation: "The map pointed toward Whispering Island." },
950-          { type: "mc", question: "Sequence: What is the correct order of events?", options: ["Found map -> Sailed seas -> Uncovered chest", "Sailed seas -> Found map -> Uncovered chest", "Uncovered chest -> Found map -> Sailed seas"], correct: 0, explanation: "Captain James first found the map, then sailed through the stormy seas, and finally uncovered the chest." },
951-          { type: "mc", question: "Character: Which word describes the journey?", options: ["Treacherous", "Boring", "Easy"], correct: 0, explanation: "The text states the journey was treacherous." },
952-          { type: "mc", question: "Vocabulary Table: Complete: Noun: Adventure, Adjective: Adventurous, Adverb: [?]", options: ["Adventurously", "Adventure", "Adventuring"], correct: 0, explanation: "The adverb form is 'adventurously'." },
953-          { type: "open", question: "Personal Opinion: Would you embark on a dangerous treasure hunt? Why or why not?" }
954-        ]
955-      },
956-      {
957-        id: "best_friends",
958-        title: "Best Friends",
959-        level: "A2",
960-        theme: "Friendship Stories",
961-        description: "A heartwarming tale about loyalty and companionship.",
962-        imageUrl: "https://image.pollinations.ai/prompt/two%20best%20friends%20smiling%20together%20storybook%20illustration?width=800&height=400&nologo=true",
963-        raw: "[N:Maya](Proper Noun) and [N:Leo](Proper Noun) [T:have been](Present Perfect - Ongoing state) best friends [P:since](Preposition of Time) childhood. They [T:shared](Past Simple) every secret and [T:supported](Past Simple) each other [ADV:constantly](Adverb of Frequency). [C:When](Subordinating Conjunction) Leo [T:faced](Past Simple) a difficult math test, Maya [T:stayed](Past Simple) up late [P:with](Preposition) him [P:to](Preposition) study.\n\nThanks [P:to](Preposition) their teamwork, Leo [T:passed](Past Simple) with flying colors. He [T:promised](Past Simple) to help Maya with her art project in return. True friendship [T:means](Present Simple - General truth) standing [P:by](Preposition) one another through thick and thin.",
964-        quiz: [
965-          { type: "mc", question: "Reference: Who helped Leo study for his math test?", options: ["Maya", "His teacher", "His brother"], correct: 0, explanation: "Maya stayed up late with him to study." },
966-          { type: "mc", question: "Sequence: What happened first?", options: ["Leo faced a difficult math test", "Leo passed the test", "Maya painted a picture"], correct: 0, explanation: "Leo faced the difficult math test first, leading Maya to help him." },
967-          { type: "mc", question: "Character: How did Maya help Leo?", options: ["She stayed up late to study with him", "She took the test for him", "She bought him a book"], correct: 0, explanation: "Maya stayed up late with him to study." },
968-          { type: "mc", question: "Vocabulary Table: Complete: Noun: Friend, Adjective: Friendly, Adverb: [?]", options: ["Friendship", "Friendlily", "Friendly"], correct: 1, explanation: "The adverb form of friendly is friendlily (or in a friendly manner)." },
969-          { type: "open", question: "Personal Opinion: What is the most important quality in a best friend?" }
970-        ]
971-      },
972-      {
973-        id: "earth_moon",
974-        title: "Earth and Its Moon",
975-        level: "B1",
976-        theme: "Space Education",
977-        description: "Exploring the fascinating cosmic bond between our planet and its lunar partner.",
978-        imageUrl: "https://image.pollinations.ai/prompt/Earth%20and%20its%20Moon%20in%20space%20educational%20storybook%20illustration?width=800&height=400&nologo=true",
979-        raw: "The [N:Earth](Proper Noun) and the [N:Moon](Proper Noun) [T:share](Present Simple - Scientific fact) a [ADJ:gravitational](Descriptive Adjective) dance that [T:stabilizes](Present Simple) our planet's axial tilt. [C:While](Conjunction) the Moon [T:orbits](Present Simple) Earth [ADV:smoothly](Adverb of Manner), its gravitational pull [T:creates](Present Simple) ocean tides.\n\nWithout this [ADJ:celestial](Descriptive Adjective) companion, Earth's climate [T:would be](Conditional - Unreal present) drastically more erratic. Scientists [T:continue](Present Simple) [P:to](Preposition) study this [ADJ:unique](Descriptive Adjective) relationship [P:to](Preposition) understand planetary formation across the cosmos.",
980-        quiz: [
981-          { type: "mc", question: "Reference: What creates ocean tides on Earth?", options: ["The Moon's gravitational pull", "Solar flares", "Wind currents"], correct: 0, explanation: "The Moon's gravitational pull creates ocean tides." },
982-          { type: "mc", question: "Sequence: What does the Moon do smoothly?", options: ["Orbits Earth", "Rotates on its axis", "Cools down"], correct: 0, explanation: "The Moon orbits Earth smoothly." },
983-          { type: "mc", question: "Character: Which adjective describes the Moon in relation to Earth?", options: ["Celestial companion", "Distant star", "Gas giant"], correct: 0, explanation: "The Moon is described as a celestial companion." },
984-          { type: "mc", question: "Vocabulary Table: Complete: Noun: Universe, Adjective: Universal, Adverb: [?]", options: ["Universally", "Universe", "Universalist"], correct: 0, explanation: "The adverb form is universally." },
985-          { type: "open", question: "Personal Opinion: Why is space education important for humanity's future?" }
986-        ]
987-      },
988-      {
989-        id: "lazy_donkey",
990-        title: "Lazy Donkey",
991-        level: "A2",
992-        theme: "Motivational Stories",
993-        description: "A humorous fable about hard work and learning responsibility.",
994-        imageUrl: "https://image.pollinations.ai/prompt/lazy%20donkey%20resting%20in%20a%20sunny%20meadow%20storybook%20illustration?width=800&height=400&nologo=true",
995-        raw: "Once, a [ADJ:stubborn](Descriptive Adjective) donkey [T:named](Past Simple) Dolo [T:refused](Past Simple) [P:to](Preposition) carry heavy sacks of salt [P:across](Preposition) the river. He [ADV:always](Adverb of Frequency) [T:tried](Past Simple) [P:tofind](Verb) shortcuts. One hot afternoon, he [T:decided](Past Simple) [P:to](Preposition) roll [P:in](Preposition) the shallow water, dissolving the salt and [T:making](Present Participle) his load [ADJ:light](Descriptive Adjective).\n\n[C:However](Conjunctive Adverb), his master [T:noticed](Past Simple) the trick [P:on](Preposition) the next trip and [T:loaded](Past Simple) the donkey with heavy wet sponges instead! When Dolo rolled [P:in](Preposition) the water again, the sponges [T:absorbed](Past Simple) tons of water, becoming [ADJ:ten times heavier](Comparative Adjective). Dolo [T:learned](Past Simple) his lesson about hard work [ADV:immediately](Adverb of Time).",
996-        quiz: [
997-          { type: "mc", question: "Reference: What did Dolo carry on the second trip?", options: ["Heavy wet sponges", "Sacks of salt", "Bags of wool"], correct: 0, explanation: "His master loaded him with heavy wet sponges." },
998-          { type: "mc", question: "Sequence: What happened when Dolo rolled in the water with sponges?", options: ["They absorbed water and became much heavier", "They dissolved completely", "They floated away"], correct: 0, explanation: "The sponges absorbed tons of water and became much heavier." },
999-          { type: "mc", question: "Character: Which word describes Dolo at the beginning?", options: ["Stubborn and lazy", "Hardworking", "Clever"], correct: 0, explanation: "Dolo tried to find shortcuts and refused to carry heavy sacks." },
1000-          { type: "mc", question: "Vocabulary Table: Complete: Noun: Laziness, Adjective: Lazy, Adverb: [?]", options: ["Lazily", "Lazy", "Laziness"], correct: 0, explanation: "The adverb form is lazily." },
1001-          { type: "open", question: "Personal Opinion: Why is trying to find dishonest shortcuts usually a bad idea?" }
1002-        ]
1003-      },
1004-      {
1005-        id: "the_butterfly",
1006-        title: "The Butterfly",
1007-        level: "A2",
1008-        theme: "Inspirational Stories",
1009-        description: "The inspiring transformation of a caterpillar into a magnificent butterfly.",
1010-        imageUrl: "https://image.pollinations.ai/prompt/a%20beautiful%20butterfly%20emerging%20from%20cocoon%20storybook%20illustration?width=800&height=400&nologo=true",
1011-        raw: "A small [N:caterpillar](Noun) [T:spent](Past Simple) weeks [T:munching](Present Participle) green leaves [P:in](Preposition) a quiet garden. [C:When](Conjunction) the time [T:was](Past Simple) right, it [T:spun](Past Simple) a tight cocoon [P:around](Preposition) itself. Inside, a [ADJ:miraculous](Descriptive Adjective) change [T:was taking place](Past Continuous).\n\nWeeks later, the shell [T:crackled](Past Simple) open, and a [ADJ:vibrant](Descriptive Adjective) butterfly [T:emerged](Past Simple). Its wings [T:unfurled](Past Simple) [ADV:gracefully](Adverb of Manner) in the warm sunshine. It [T:flew](Past Simple) high into the sky, proving that great beauty comes [P:from](Preposition) patient perseverance.",
1012-        quiz: [
1013-          { type: "mc", question: "Reference: What did the caterpillar spin around itself?", options: ["A tight cocoon", "A spider web", "A silk scarf"], correct: 0, explanation: "It spun a tight cocoon around itself." },
1014-          { type: "mc", question: "Sequence: What happened after weeks in the cocoon?", options: ["It emerged as a vibrant butterfly", "It turned back into a leaf", "It fell to the ground"], correct: 0, explanation: "A vibrant butterfly emerged from the shell." },
1015-          { type: "mc", question: "Character: How did the butterfly's wings unfurl?", options: ["Gracefully", "Quickly and violently", "Awkwardly"], correct: 0, explanation: "Its wings unfurled gracefully in the warm sunshine." },
1016-          { type: "mc", question: "Vocabulary Table: Complete: Noun: Beauty, Adjective: Beautiful, Adverb: [?]", options: ["Beautifully", "Beauty", "Beautify"], correct: 0, explanation: "The adverb form is beautifully." },
1017-          { type: "open", question: "Personal Opinion: How does patience help us grow through difficult times?" }
1018-        ]
1019-      },
1020-      {
1021-        id: "four_friends",
1022-        title: "Four Friends",
1023-        level: "A2",
1024-        theme: "Animal Stories",
1025-        description: "Four woodland animals working together to overcome a challenge.",
1026-        imageUrl: "https://image.pollinations.ai/prompt/four%20different%20animals%20cooperating%20in%20forest%20storybook%20illustration?width=800&height=400&nologo=true",
1027-        raw: "In a lush green forest, a [N:deer](Noun), a [N:rabbit](Noun), a [N:squirrel](Noun), and a [N:hedgehog](Noun) [T:lived](Past Simple) [ADV:harmoniously](Adverb of Manner). [C:Whenever](Conjunction) danger [T:approached](Past Simple), they [T:warned](Past Simple) each other [ADV:instantly](Adverb of Time). One autumn day, a deep ravine [N:blocked](Past Simple) their path to the orchard.\n\nThe clever squirrel [T:jumped](Past Simple) across with a vine, the strong deer [T:anchored](Past Simple) it, and together they [T:built](Past Simple) a sturdy bridge. All four animals [T:crossed](Past Simple) safely, celebrating the power [P:of](Preposition) true cooperation.",
1028-        quiz: [
1029-          { type: "mc", question: "Reference: What blocked their path to the orchard?", options: ["A deep ravine", "A fallen tree", "A wide river"], correct: 0, explanation: "A deep ravine blocked their path." },
1030-          { type: "mc", question: "Sequence: Who jumped across with a vine first?", options: ["The squirrel", "The deer", "The hedgehog"], correct: 0, explanation: "The clever squirrel jumped across with a vine." },
1031-          { type: "mc", question: "Character: Which animal anchored the vine?", options: ["The strong deer", "The rabbit", "The squirrel"], correct: 0, explanation: "The strong deer anchored it." },
1032-          { type: "mc", question: "Vocabulary Table: Complete: Noun: Cooperation, Verb: Cooperate, Adjective: [?]", options: ["Cooperative", "Cooperates", "Cooperating"], correct: 0, explanation: "The adjective form is cooperative." },
1033-          { type: "open", question: "Personal Opinion: Why is teamwork often better than trying to solve everything alone?" }
1034-        ]
1035-      },
1036-      {
1037-        id: "foolish_monkeys",
1038-        title: "Foolish Monkeys",
1039-        level: "A2",
1040-        theme: "General Stories",
1041-        description: "An amusing lesson about wisdom, patience, and foolish choices.",
1042-        imageUrl: "https://image.pollinations.ai/prompt/funny%20monkeys%20playing%20in%20jungle%20trees%20storybook%20illustration?width=800&height=400&nologo=true",
1043-        raw: "A troop [P:of](Preposition) [ADJ:lively](Descriptive Adjective) monkeys [T:swung](Past Simple) through the jungle canopy [P:on](Preposition) a chilly winter night. They [T:shivered](Past Simple) [ADV:uncontrollably](Adverb of Manner) until they [T:spotted](Past Simple) a glowing firefly.\n\n[N:Mistaking](Gerund) the bug for a burning ember, they [T:gathered](Past Simple) [ADV:eagerly](Adverb of Manner) around it and [T:began](Past Simple) blowing on it [P:to](Preposition) create warmth. An [ADJ:observant](Descriptive Adjective) owl [T:warned](Past Simple) them [C:that](Conjunction) bugs produce no heat, [C:but](Conjunction) the foolish monkeys [T:ignored](Past Simple) the wise advice and [T:kept](Past Simple) shivering.",
1044-        quiz: [
1045-          { type: "mc", question: "Reference: What did the monkeys mistake for a burning ember?", options: ["A glowfly / firefly", "A glowing leaf", "A red flower"], correct: 0, explanation: "They mistook a glowing firefly for a burning ember." },
1046-          { type: "mc", question: "Sequence: What happened after the owl warned them?", options: ["They ignored the advice and kept shivering", "They built a real fire", "They went to sleep"], correct: 0, explanation: "The foolish monkeys ignored the wise advice and kept shivering." },
1047-          { type: "mc", question: "Character: Which adjective best describes the owl?", options: ["Observant and wise", "Foolish", "Lively"], correct: 0, explanation: "The owl gave wise advice and is described as observant." },
1048-          { type: "mc", question: "Vocabulary Table: Complete: Noun: Wisdom, Adjective: Wise, Adverb: [?]", options: ["Wisely", "Wisdom", "Wiser"], correct: 0, explanation: "The adverb form of wise is wisely." },
1049-          { type: "open", question: "Personal Opinion: Why is it important to listen to good advice?" }
1050-        ]
1051-      },
1052-      {
1053-        id: "ant_dove",
1054-        title: "The Ant and the Dove",
1055-        level: "A2",
1056-        theme: "Moral Stories",
1057-        description: "A classic Aesop's fable about kindness returning twofold.",
1058-        imageUrl: "https://image.pollinations.ai/prompt/tiny%20ant%20and%20a%20white%20dove%20near%20stream%20storybook%20illustration?width=800&height=400&nologo=true",
1059-        raw: "A tiny [N:ant](Noun) [T:went](Past Simple) down [P:to](Preposition) a brook [P:to](Preposition) drink water, [C:but](Conjunction) a strong current [T:swept](Past Simple) him away. A [ADJ:kind](Descriptive Adjective) dove [P:perched](Past Participle) on a nearby tree [T:noticed](Past Simple) the struggling ant and [T:dropped](Past Simple) a leaf [P:into](Preposition) the water.\n\nThe ant [T:climbed](Past Simple) onto the leaf [P:and](Conjunction) [T:floated](Past Simple) safely ashore. Days later, when a hunter [T:aimed](Past Simple) his net [P:at](Preposition) the dove, the grateful ant [T:bitten](Past Simple) the hunter's ankle [ADV:sharp](Adverb of Manner), causing him [P:to](Preposition) drop his weapon. The dove [T:escaped](Past Simple), proving that one good turn [T:deserves](Present Simple) another.",
1060-        quiz: [
1061-          { type: "mc", question: "Reference: What did the dove drop into the water to save the ant?", options: ["A leaf", "A twig", "A feather"], correct: 0, explanation: "The dove dropped a leaf into the water." },
1062-          { type: "mc", question: "Sequence: What happened after the ant floated ashore?", options: ["Days later, the ant saved the dove from a hunter", "The ant thanked the dove immediately", "They built a nest together"], correct: 0, explanation: "Days later, the ant bit the hunter to save the dove." },
1063-          { type: "mc", question: "Character: Which word describes the dove?", options: ["Kind and helpful", "Selfish", "Careless"], correct: 0, explanation: "The dove was kind and helped the ant." },
1064-          { type: "mc", question: "Vocabulary Table: Complete: Noun: Kindness, Adjective: Kind, Adverb: [?]", options: ["Kindly", "Kindness", "Kinda"], correct: 0, explanation: "The adverb form of kind is kindly." },
1065-          { type: "open", question: "Personal Opinion: Have you ever helped someone who later helped you back?" }
1066-        ]
1067-      },
1068-      {
1069-        id: "fox_grapes",
1070-        title: "The Fox and the Sour Grapes",
1071-        level: "A2",
1072-        theme: "Funny Fables",
1073-        description: "A humorous tale of a hungry fox trying to reach delicious grapes.",
1074-        imageUrl: "https://image.pollinations.ai/prompt/funny%20red%20fox%20looking%20up%20at%20hanging%20purple%20grapes%20storybook%20illustration?width=800&height=400&nologo=true",
1075-        raw: "One sunny afternoon, a [ADJ:hungry](Descriptive Adjective) fox [T:spotted](Past Simple) a bunch [P:of](Preposition) [ADJ:juicy](Descriptive Adjective) purple grapes [T:hanging](Present Participle) high from a vine. He [T:jumped](Past Simple) [ADV:high](Adverb of Manner) into the air [P:with](Preposition) all his might, [C:but](Conjunction) he [T:missed](Past Simple) the branch [ADV:completely](Adverb of Degree).\n\nAfter trying several more times [P:without](Preposition) success, the fox [T:trotted](Past Simple) away [ADV:proudly](Adverb of Manner) and [T:muttered](Past Simple), 'I am sure the grapes are [ADJ:sour](Descriptive Adjective) anyway; they are not worth [N:having](Gerund).' Everyone laughs at those who pretend to despise what they cannot reach.",
1076-        quiz: [
1077-          { type: "mc", question: "Reference: What did the fox see hanging from the vine?", options: ["Juicy purple grapes", "Ripe apples", "Sweet honey"], correct: 0, explanation: "He spotted a bunch of juicy purple grapes." },
1078-          { type: "mc", question: "Sequence: What did the fox do after failing to reach the grapes?", options: ["He walked away saying they were sour", "He climbed the tree", "He asked a bird for help"], correct: 0, explanation: "He trotted away and muttered that the grapes were sour anyway." },
1079-          { type: "mc", question: "Character: How did the fox jump?", options: ["High into the air with all his might", "Slowly and lazily", "Only once"], correct: 0, explanation: "He jumped high into the air with all his might." },
1080-          { type: "mc", question: "Vocabulary Table: Complete: Noun: Hunger, Adjective: Hungry, Adverb: [?]", options: ["Hungrily", "Hunger", "Hungriest"], correct: 0, explanation: "The adverb form is hungrily." },
1081-          { type: "open", question: "Personal Opinion: Why do people sometimes pretend they don't want something when they fail to get it?" }
1082-        ]
1083-      },
1084-      {
1085-        id: "thirsty_crow",
1086-        title: "The Thirsty Crow",
1087-        level: "A2",
1088-        theme: "Animal Wisdom",
1089-        description: "A clever bird uses brainpower to solve a difficult puzzle.",
1090-        imageUrl: "https://image.pollinations.ai/prompt/clever%20black%20crow%20dropping%20pebbles%20into%20a%20pitcher%20storybook%20illustration?width=800&height=400&nologo=true",
1091-        raw: "During a [ADJ:scorching](Descriptive Adjective) summer day, a thirsty [N:crow](Noun) [T:searched](Past Simple) [ADV:desperately](Adverb of Manner) for water. Finally, he [T:discovered](Past Simple) a tall pitcher with just a little water [P:at](Preposition) the bottom. His beak [T:could not reach](Modal Verb + Verb) the liquid [C:because](Conjunction) the neck [T:was](Past Simple) too narrow.\n\nInstead [P:of](Preposition) giving up, the [ADJ:ingenious](Descriptive Adjective) bird [T:collected](Past Simple) small pebbles [P:one](Number) by one and [T:dropped](Past Simple) them into the pitcher. [ADV:gradually](Adverb of Time), the water level [T:rose](Past Simple) high enough for him [P:to](Preposition) drink. [N:Creativity](Noun) [T:wins](Present Simple) over obstacles.",
1092-        quiz: [
1093-          { type: "mc", question: "Reference: What did the crow find?", options: ["A tall pitcher with water at the bottom", "A deep lake", "A fresh stream"], correct: 0, explanation: "He discovered a tall pitcher with just a little water at the bottom." },
1094-          { type: "mc", question: "Sequence: What did the crow drop into the pitcher?", options: ["Small pebbles", "Green leaves", "Wooden sticks"], correct: 0, explanation: "He collected small pebbles and dropped them into the pitcher." },
1095-          { type: "mc", question: "Character: Which word describes the crow's problem-solving?", options: ["Ingenious and clever", "Lazy", "Careless"], correct: 0, explanation: "The bird was ingenious and found a smart solution." },
1096-          { type: "mc", question: "Vocabulary Table: Complete: Noun: Thirst, Adjective: Thirsty, Adverb: [?]", options: ["Thirstily", "Thirst", "Thirstier"], correct: 0, explanation: "The adverb form is thirstily." },
1097-          { type: "open", question: "Personal Opinion: Tell about a time when you solved a hard problem by thinking creatively." }
1098-        ]
1099-      },
1100-      {
1101-        id: "lion_mouse",
1102-        title: "The Lion and the Mouse",
1103-        level: "A2",
1104-        theme: "Animal Stories",
1105-        description: "A giant lion learns that even the smallest friend can be of great help.",
1106-        imageUrl: "https://image.pollinations.ai/prompt/mighty%20lion%20and%20tiny%20mouse%20in%20sunny%20savannah%20storybook%20illustration?width=800&height=400&nologo=true",
1107-        raw: "A mighty [N:lion](Noun) [T:was sleeping](Past Continuous) peacefully [P:under](Preposition) a shady tree when a playful [N:mouse](Noun) [T:accidentally](Adverb of Manner) ran across his nose. The awakened lion [T:grabbed](Past Simple) the tiny creature [ADV:angrily](Adverb of Manner). [C:However], the frightened mouse [T:begged](Past Simple) for mercy, [T:promising](Present Participle) to repay the favor one day. The amused lion [T:released](Past Simple) him [ADV:kindly](Adverb of Manner).\n\nWeeks later, hunters [T:trapped](Past Simple) the powerful lion in a strong rope net. Hearing his roars, the little mouse [T:rushed](Past Simple) [P:to](Preposition) the scene and [T:gnawed](Past Simple) through the ropes [P:with](Preposition) his sharp teeth. The lion [T:escaped](Past Simple), realizing that true friends come [P:in](Preposition) all sizes.",
1108-        quiz: [
1109-          { type: "mc", question: "Reference: What did the mouse do when caught by the lion?", options: ["Begged for mercy and promised to help later", "Bit the lion's paw", "Ran away quickly"], correct: 0, explanation: "The mouse begged for mercy and promised to repay the favor." },
1110-          { type: "mc", question: "Sequence: What happened after the lion was trapped in a net?", options: ["The mouse gnawed the ropes and freed him", "The lion broke free by himself", "Another lion rescued him"], correct: 0, explanation: "The little mouse rushed to the scene and gnawed through the ropes." },
1111-          { type: "mc", question: "Character: How did the lion feel when the mouse promised to help?", options: ["Amused", "Angry", "Frightened"], correct: 0, explanation: "The amused lion released him." },
1112-          { type: "mc", question: "Vocabulary Table: Complete: Noun: Power, Adjective: Powerful, Adverb: [?]", options: ["Powerfully", "Power", "Powered"], correct: 0, explanation: "The adverb form is powerfully." },
1113-          { type: "open", question: "Personal Opinion: How does this story show that nobody is too small to make a difference?" }
1114-        ]
1115-      },
1116-
1117-    ];
1118-
1119-    let currentStory = allStories[0];
1120-    let parsedTokens = [];
1121-    let pages = [];
1122-    let currentPage = 0;
1123-    let activeFilter = null;
1124-    let currentFontSizeIdx = 1;
1125-    const fontSizes = ['font-14', 'font-16', 'font-18', 'font-21'];
1126-    let isSpeaking = false;
1127-    let currentSpeed = 1.0;
1128-    let currentAccent = 'en-US';
1129-    let currentAnnotationWord = "";
1130-    let currentAnnotationObj = null;
1131-
1132-    let savedVocab = JSON.parse(localStorage.getItem('lingo_saved_vocab')) || [];
1133-    let bookmarkedIds = JSON.parse(localStorage.getItem('lingo_bookmarks')) || [];
1134-
1135-    let ambientAudioCtx = null;
1136-    let ambientGainNode = null;
1137-    let ambientNoiseNode = null;
1138-    let isAmbientOn = false;
1139-
1140-    function init() {
1141-      loadStory(currentStory);
1142-      document.getElementById('libCount').innerText = allStories.length;
1143-      updateVocabCount();
1144-      renderFeedbacks();
1145-      setTimeout(initPageCurlEngine, 100);
1146-    }
1147-
1148-    function loadStory(story) {
1149-      const readerEl = document.querySelector('.reader-scroll');
1150-      if (readerEl && currentStory && currentStory.id !== story.id) {
1151-        readerEl.classList.add('story-fade-out');
1152-        setTimeout(() => {
1153-          renderStoryContent(story);
1154-          readerEl.classList.remove('story-fade-out');
1155-          readerEl.classList.remove('story-slide-in');
1156-          void readerEl.offsetWidth; // force reflow
1157-          readerEl.classList.add('story-slide-in');
1158-          readerEl.scrollTop = 0;
1159-        }, 180);
1160-      } else {
1161-        renderStoryContent(story);
1162-        if (readerEl) {
1163-          readerEl.classList.remove('story-slide-in');
1164-          void readerEl.offsetWidth;
1165-          readerEl.classList.add('story-slide-in');
1166-        }
1167-      }
1168-    }
1169-
1170-    function renderStoryContent(story) {
1171-      currentStory = story;
1172-      document.getElementById('storyTitle').innerText = story.title;
1173-      document.getElementById('storyThemeDesc').innerText = story.description;
1174-      
1175-      const badge = document.getElementById('levelBadge');
1176-      badge.innerText = story.level + " Level";
1177-      badge.className = `badge badge-${story.level.toLowerCase()}`;
1178-      document.getElementById('themeBadge').innerText = story.theme;
1179-
1180-      // LOAD IMAGE LOGIC
1181-      const imgEl = document.getElementById('storyHeroImage');
1182-      if (story.imageUrl) {
1183-        imgEl.src = story.imageUrl;
1184-        imgEl.style.display = 'block';
1185-      } else {
1186-        imgEl.style.display = 'none';
1187-      }
1188-
1189-      parseStoryMarkup(story.raw);
1190-      renderFullStory();
1191-      renderQuiz();
1192-      renderFeedbacks();
1193-      updateBookmarkButton();
1194-      scanAndUpdateAdaptiveSoundscape(story);
1195-      stopAudio();
1196-    }
1197-
1198-    let fullPlainString = "";
1199-
1200-    function parseStoryMarkup(rawText) {
1201-      parsedTokens = [];
1202-      fullPlainString = "";
1203-      const regex = /\[(L|T|C|N|ADJ|ADV|P|S)(?::([^:\]]+))?(?::([^\]]+))?\]\(([^)]+)\)/g;
1204-      let lastIndex = 0;
1205-      let match;
1206-
1207-      while ((match = regex.exec(rawText)) !== null) {
1208-        if (match.index > lastIndex) {
1209-          const chunk = rawText.substring(lastIndex, match.index);
1210-          const subRegex = /(\s+|\S+)/g;
1211-          let subMatch;
1212-          while ((subMatch = subRegex.exec(chunk)) !== null) {
1213-            const part = subMatch[0];
1214-            if (/^\s+$/.test(part)) {
1215-              parsedTokens.push({ type: 'WS', text: part });
1216-              fullPlainString += part;
1217-            } else {
1218-              const start = fullPlainString.length;
1219-              fullPlainString += part;
1220-              const end = fullPlainString.length;
1221-              parsedTokens.push({
1222-                type: 'TEXT',
1223-                text: part,
1224-                charStart: start,
1225-                charEnd: end
1226-              });
1227-            }
1228-          }
1229-        }
1230-
1231-        const [_, tagType, p1, p2, info] = match;
1232-        const word = (p2 && p2.trim()) ? p2.trim() : (p1 ? p1.trim() : "");
1233-        const extra = (p2 && p2.trim()) ? p1.trim() : "";
1234-
1235-        const start = fullPlainString.length;
1236-        fullPlainString += word;
1237-        const end = fullPlainString.length;
1238-
1239-        parsedTokens.push({
1240-          type: tagType,
1241-          text: word,
1242-          info: info.trim(),
1243-          extra: extra,
1244-          charStart: start,
1245-          charEnd: end
1246-        });
1247-
1248-        lastIndex = regex.lastIndex;
1249-      }
1250-
1251-      if (lastIndex < rawText.length) {
1252-        const chunk = rawText.substring(lastIndex);
1253-        const subRegex = /(\s+|\S+)/g;
1254-        let subMatch;
1255-        while ((subMatch = subRegex.exec(chunk)) !== null) {
1256-          const part = subMatch[0];
1257-          if (/^\s+$/.test(part)) {
1258-            parsedTokens.push({ type: 'WS', text: part });
1259-            fullPlainString += part;
1260-          } else {
1261-            const start = fullPlainString.length;
1262-            fullPlainString += part;
1263-            const end = fullPlainString.length;
1264-            parsedTokens.push({
1265-              type: 'TEXT',
1266-              text: part,
1267-              charStart: start,
1268-              charEnd: end
1269-            });
1270-          }
1271-        }
1272-      }
1273-    }
1274-
1275-    function renderFullStory() {
1276-      const content = document.getElementById('storyContent');
1277-      content.innerHTML = "";
1278-
1279-      parsedTokens.forEach((token) => {
1280-        if (token.type === 'WS') {
1281-          content.appendChild(document.createTextNode(token.text));
1282-        } else if (token.type === 'TEXT') {
1283-          const span = document.createElement('span');
1284-          span.innerText = token.text;
1285-          span.className = 'story-word';
1286-          span.dataset.start = token.charStart;
1287-          span.dataset.end = token.charEnd;
1288-          content.appendChild(span);
1289-        } else {
1290-          const span = document.createElement('span');
1291-          span.innerText = token.text;
1292-          span.className = `story-word part part-${token.type.toLowerCase()}`;
1293-          span.dataset.start = token.charStart;
1294-          span.dataset.end = token.charEnd;
1295-          span.style.opacity = (activeFilter && activeFilter !== token.type) ? "0.35" : "1";
1296-          span.onclick = (e) => {
1297-            e.stopPropagation();
1298-            checkSpokenWordForSoundEffects(token.text.toLowerCase());
1299-            showAnnotationModal(token);
1300-          };
1301-          content.appendChild(span);
1302-        }
1303-      });
1304-    }
1305-
1306-    function setGrammarFilter(type, btn) {
1307-      activeFilter = type;
1308-      document.querySelectorAll('.filter-pill').forEach(p => p.classList.remove('active'));
1309-      btn.classList.add('active');
1310-      renderFullStory();
1311-    }
1312-
1313-    const smartLexisDb = {
1314-      "hungry": { syn: ["famished", "ravenous", "starving"], ant: ["full", "satiated", "stuffed"], example: "After walking all afternoon, the children felt very hungry." },
1315-      "scorching": { syn: ["blistering", "sweltering", "blazing"], ant: ["freezing", "chilly", "cool"], example: "The travelers sought shade from the scorching desert sun." },
1316-      "ingenious": { syn: ["brilliant", "inventive", "clever"], ant: ["foolish", "dull", "uninspired"], example: "She came up with an ingenious solution to the puzzle." },
1317-      "mighty": { syn: ["powerful", "strong", "robust"], ant: ["weak", "fragile", "feeble"], example: "The mighty oak tree stood firm against the storm." },
1318-      "swift": { syn: ["fast", "rapid", "quick"], ant: ["slow", "sluggish"], example: "The swift river rushed down the mountain valley." },
1319-      "peacefully": { syn: ["quietly", "calmly", "serenely"], ant: ["noisily", "turbulently", "restlessly"], example: "The baby slept peacefully in her crib." },
1320-      "desperately": { syn: ["urgently", "frantically", "intensely"], ant: ["calmly", "indifferently"], example: "He searched desperately for his lost keys before the meeting." },
1321-      "accidentally": { syn: ["unintentionally", "inadvertently", "by chance"], ant: ["deliberately", "purposely", "intentionally"], example: "She accidentally dropped her favorite coffee mug." }
1322-    };
1323-
1324-    function getSmartLexis(word, type, info) {
1325-      const key = word.toLowerCase();
1326-      if (smartLexisDb[key]) {
1327-        return smartLexisDb[key];
1328-      }
1329-      let syn = ["notable", "significant", "expressive"];
1330-      let ant = ["ordinary", "unremarkable"];
1331-      let example = `In context, "${word}" is used to convey "${info}".`;
1332-      
1333-      if (type === "ADJ") {
1334-        syn = ["notable", "striking", "expressive"];
1335-        ant = ["ordinary", "unremarkable"];
1336-        example = `The travelers noticed the ${word} scenery along the winding path.`;
1337-      } else if (type === "ADV") {
1338-        syn = ["greatly", "markedly"];
1339-        ant = ["moderately", "slightly"];
1340-        example = `She completed the task quite ${word} under pressure.`;
1341-      } else if (type === "T" || type === "VERB") {
1342-        syn = ["perform", "execute", "act"];
1343-        ant = ["cease", "halt"];
1344-        example = `They decided to ${word} with great care and attention.`;
1345-      } else if (type === "N") {
1346-        syn = ["entity", "concept", "element"];
1347-        ant = ["abstraction"];
1348-        example = `The new ${word} brought fresh ideas to the discussion.`;
1349-      }
1350-      return { syn, ant, example };
1351-    }
1352-
1353-    function showAnnotationModal(token) {
1354-      currentAnnotationWord = token.text;
1355-      currentAnnotationObj = token;
1356-      document.getElementById('sheetWord').innerText = token.text;
1357-      document.getElementById('sheetTypeTitle').innerText = token.extra ? token.extra : token.type;
1358-      document.getElementById('sheetBadge').innerText = token.type;
1359-      document.getElementById('sheetDesc').innerText = token.info;
1360-
1361-      const lexis = getSmartLexis(token.text, token.type, token.info);
1362-      document.getElementById('sheetSynonyms').innerText = lexis.syn.join(', ');
1363-      document.getElementById('sheetAntonyms').innerText = lexis.ant.join(', ');
1364-      document.getElementById('sheetExample').innerText = `"${lexis.example}"`;
1365-
1366-      openModal('annotationModal');
1367-    }
1368-
1369-    function saveCurrentWordToVocab() {
1370-      if (!currentAnnotationObj) return;
1371-      const lexis = getSmartLexis(currentAnnotationObj.text, currentAnnotationObj.type, currentAnnotationObj.info);
1372-      const item = {
1373-        word: currentAnnotationObj.text,
1374-        type: currentAnnotationObj.type,
1375-        extra: currentAnnotationObj.extra || '',
1376-        info: currentAnnotationObj.info,
1377-        syn: lexis.syn.join(', '),
1378-        ant: lexis.ant.join(', '),
1379-        example: lexis.example,
1380-        date: new Date().toLocaleDateString()
1381-      };
1382-      // Prevent duplicates
1383-      if (!savedVocab.some(v => v.word.toLowerCase() === item.word.toLowerCase())) {
1384-        savedVocab.push(item);
1385-        localStorage.setItem('lingo_saved_vocab', JSON.stringify(savedVocab));
1386-        updateVocabCount();
1387-        alert(`Saved "${item.word}" to your Vocabulary Notebook!`);
1388-      } else {
1389-        alert(`"${item.word}" is already in your Vocabulary Notebook.`);
1390-      }
1391-      closeModalDirect('annotationModal');
1392-    }
1393-
1394-    function updateVocabCount() {
1395-      document.getElementById('vocabCount').innerText = savedVocab.length;
1396-    }
1397-
1398-    function openVocabNotebook() {
1399-      const list = document.getElementById('vocabList');
1400-      list.innerHTML = "";
1401-      if (savedVocab.length === 0) {
1402-        list.innerHTML = `<div style="text-align:center; padding:20px; color:var(--text-muted); font-size:13px;">No saved words yet. Tap on any highlighted word while reading and click "Save to Vocab Notebook".</div>`;
1403-      } else {
1404-        savedVocab.forEach((v, idx) => {
1405-          const div = document.createElement('div');
1406-          div.style = "padding:12px; margin-bottom:10px; border-radius:10px; border:1px solid var(--border); background:var(--surface-variant);";
1407-          div.innerHTML = `
1408-            <div style="display:flex; justify-content:space-between; align-items:flex-start;">
1409-              <div>
1410-                <div style="font-weight:700; font-size:14px; color:var(--primary);">${v.word} <span style="font-size:10.5px; font-weight:normal; color:var(--text-muted);">(${v.type})</span></div>
1411-                <div style="font-size:12px; color:var(--text-main); margin-top:3px;">${v.info}</div>
1412-                ${v.syn ? `<div style="font-size:11px; margin-top:4px; color:var(--text-muted);"><strong>Syn:</strong> ${v.syn} | <strong>Ant:</strong> ${v.ant}</div>` : ''}
1413-                ${v.example ? `<div style="font-size:11px; font-style:italic; margin-top:2px; color:var(--text-muted);">"${v.example}"</div>` : ''}
1414-              </div>
1415-              <button class="btn-pill" style="padding:4px 8px; font-size:10px; background:#ef4444; color:white; border:none;" onclick="removeVocabWord(${idx})">Remove</button>
1416-            </div>
1417-          `;
1418-          list.appendChild(div);
1419-        });
1420-      }
1421-      openModal('vocabModal');
1422-    }
1423-
1424-    function removeVocabWord(idx) {
1425-      savedVocab.splice(idx, 1);
1426-      localStorage.setItem('lingo_saved_vocab', JSON.stringify(savedVocab));
1427-      updateVocabCount();
1428-      openVocabNotebook();
1429-    }
1430-
1431-    function toggleBookmark() {
1432-      if (!currentStory) return;
1433-      const idx = bookmarkedIds.indexOf(currentStory.id);
1434-      if (idx > -1) {
1435-        bookmarkedIds.splice(idx, 1);
1436-      } else {
1437-        bookmarkedIds.push(currentStory.id);
1438-      }
1439-      localStorage.setItem('lingo_bookmarks', JSON.stringify(bookmarkedIds));
1440-      updateBookmarkButton();
1441-    }
1442-
1443-    function updateBookmarkButton() {
1444-      const btn = document.getElementById('bookmarkBtn');
1445-      if (currentStory && bookmarkedIds.includes(currentStory.id)) {
1446-        btn.innerText = "★";
1447-        btn.style.color = "#f59e0b";
1448-      } else {
1449-        btn.innerText = "☆";
1450-        btn.style.color = "inherit";
1451-      }
1452-    }
1453-
1454-    // --- ADAPTIVE SOUNDSCAPE & WEB AUDIO SYNTHESIZER ENGINE ---
1455-    let soundCtx = null;
1456-    let masterGainNode = null;
1457-    let masterVolume = 0.2;
1458-    let currentAmbientLoop = null; // 'rain', 'wind', 'birds', 'waves', null
1459-    let ambientBufferNode = null;
1460-    let ambientGainNode = null;
1461-    let ambientModOsc = null;
1462-    let ambientModGain = null;
1463-    let autoAdaptiveEnabled = true;
1464-    let lastEventTimeMap = {};
1465-
1466-    function getAudioCtx() {
1467-      if (!soundCtx) {
1468-        soundCtx = new (window.AudioContext || window.webkitAudioContext)();
1469-        masterGainNode = soundCtx.createGain();
1470-        masterGainNode.gain.value = masterVolume;
1471-        masterGainNode.connect(soundCtx.destination);
1472-      }
1473-      if (soundCtx.state === 'suspended') {
1474-        soundCtx.resume();
1475-      }
1476-      return soundCtx;
1477-    }
1478-
1479-    function setMasterVolume(val) {
1480-      masterVolume = parseFloat(val);
1481-      if (masterGainNode) {
1482-        masterGainNode.gain.setValueAtTime(masterVolume, soundCtx.currentTime);
1483-      }
1484-    }
1485-
1486-    function openSoundscapeStudio() {
1487-      openModal('soundscapeModal');
1488-    }
1489-
1490-    function toggleAutoAdaptive() {
1491-      autoAdaptiveEnabled = !autoAdaptiveEnabled;
1492-      const autoBtn = document.getElementById('autoToggleBtn');
1493-      const modalBtn = document.getElementById('modalAutoToggle');
1494-      if (autoAdaptiveEnabled) {
1495-        if (autoBtn) {
1496-          autoBtn.innerText = "🎵 Auto: ON";
1497-          autoBtn.className = "sound-chip active-auto";
1498-        }
1499-        if (modalBtn) modalBtn.innerText = "🎵 Auto-Adaptive Mode: Enabled";
1500-        if (currentStory) scanAndUpdateAdaptiveSoundscape(currentStory);
1501-      } else {
1502-        if (autoBtn) {
1503-          autoBtn.innerText = "🎵 Auto: OFF";
1504-          autoBtn.className = "sound-chip";
1505-        }
1506-        if (modalBtn) modalBtn.innerText = "🎵 Auto-Adaptive Mode: Disabled";
1507-      }
1508-    }
1509-
1510-    function stopAllSounds() {
1511-      if (ambientBufferNode) {
1512-        try { ambientBufferNode.stop(); } catch(e){}
1513-        ambientBufferNode = null;
1514-      }
1515-      if (ambientModOsc) {
1516-        try { ambientModOsc.stop(); } catch(e){}
1517-        ambientModOsc = null;
1518-      }
1519-      currentAmbientLoop = null;
1520-      updateSoundBadge("🎧", "Soundscape: Off", "#6b7280");
1521-    }
1522-
1523-    function updateSoundBadge(icon, text, color = "var(--primary)") {
1524-      const iconEl = document.getElementById('soundBadgeIcon');
1525-      const textEl = document.getElementById('soundBadgeText');
1526-      if (iconEl) iconEl.innerText = icon;
1527-      if (textEl) {
1528-        textEl.innerText = text;
1529-        textEl.style.color = color;
1530-      }
1531-      const topBtn = document.getElementById('ambientBtn');
1532-      if (topBtn) {
1533-        topBtn.innerText = `${icon} ${text.split(':')[0]}`;
1534-      }
1535-    }
1536-
1537-    function triggerSoundEffect(type) {
1538-      const ctx = getAudioCtx();
1539-      if (!ctx) return;
1540-
1541-      if (type === 'lion') {
1542-        playLionRoar();
1543-      } else if (type === 'laugh') {
1544-        playLaugh();
1545-      } else if (type === 'thunder') {
1546-        playThunder();
1547-      } else if (type === 'rain') {
1548-        startRainSoundscape();
1549-      } else if (type === 'wind') {
1550-        startWindSoundscape();
1551-      } else if (type === 'birds') {
1552-        startForestBirdsSoundscape();
1553-      } else if (type === 'waves') {
1554-        startWavesSoundscape();
1555-      }
1556-    }
1557-
1558-    // 1. LION ROAR SYNTHESIZER
1559-    function playLionRoar() {
1560-      const ctx = getAudioCtx();
1561-      const now = ctx.currentTime;
1562-
1563-      const osc1 = ctx.createOscillator();
1564-      const osc2 = ctx.createOscillator();
1565-      const growlLfo = ctx.createOscillator();
1566-      const growlGain = ctx.createGain();
1567-      const filter = ctx.createBiquadFilter();
1568-      const roarGain = ctx.createGain();
1569-
1570-      osc1.type = 'sawtooth';
1571-      osc2.type = 'triangle';
1572-
1573-      osc1.frequency.setValueAtTime(140, now);
1574-      osc1.frequency.exponentialRampToValueAtTime(40, now + 1.8);
1575-      osc2.frequency.setValueAtTime(130, now);
1576-      osc2.frequency.exponentialRampToValueAtTime(36, now + 1.8);
1577-
1578-      growlLfo.frequency.value = 8;
1579-      growlGain.gain.value = 0.3;
1580-      growlLfo.connect(growlGain.gain);
1581-
1582-      filter.type = 'lowpass';
1583-      filter.frequency.setValueAtTime(650, now);
1584-      filter.frequency.exponentialRampToValueAtTime(200, now + 1.8);
1585-      filter.Q.value = 4.0;
1586-
1587-      roarGain.gain.setValueAtTime(0.001, now);
1588-      roarGain.gain.linearRampToValueAtTime(0.8, now + 0.15);
1589-      roarGain.gain.exponentialRampToValueAtTime(0.001, now + 1.8);
1590-
1591-      osc1.connect(filter);
1592-      osc2.connect(filter);
1593-      filter.connect(growlGain);
1594-      growlGain.connect(roarGain);
1595-      roarGain.connect(masterGainNode);
1596-
1597-      osc1.start(now);
1598-      osc2.start(now);
1599-      growlLfo.start(now);
1600-
1601-      osc1.stop(now + 1.8);
1602-      osc2.stop(now + 1.8);
1603-      growlLfo.stop(now + 1.8);
1604-
1605-      updateSoundBadge("🦁", "Event: Lion Roar!", "#d97706");
1606-    }
1607-
1608-    // 2. LAUGHTER SYNTHESIZER
1609-    function playLaugh() {
1610-      const ctx = getAudioCtx();
1611-      const now = ctx.currentTime;
1612-
1613-      const pulses = 6;
1614-      for (let i = 0; i < pulses; i++) {
1615-        const t = now + i * 0.15;
1616-        const osc = ctx.createOscillator();
1617-        const gain = ctx.createGain();
1618-        const filter = ctx.createBiquadFilter();
1619-
1620-        osc.type = 'sawtooth';
1621-        const startFreq = 420 + Math.sin(i * 0.8) * 40;
1622-        osc.frequency.setValueAtTime(startFreq, t);
1623-        osc.frequency.exponentialRampToValueAtTime(startFreq - 80, t + 0.12);
1624-
1625-        filter.type = 'bandpass';
1626-        filter.frequency.value = 800;
1627-        filter.Q.value = 2.0;
1628-
1629-        gain.gain.setValueAtTime(0.001, t);
1630-        gain.gain.linearRampToValueAtTime(0.5, t + 0.02);
1631-        gain.gain.exponentialRampToValueAtTime(0.001, t + 0.12);
1632-
1633-        osc.connect(filter);
1634-        filter.connect(gain);
1635-        gain.connect(masterGainNode);
1636-
1637-        osc.start(t);
1638-        osc.stop(t + 0.13);
1639-      }
1640-
1641-      updateSoundBadge("😆", "Event: Cheerful Laughter!", "#db2777");
1642-    }
1643-
1644-    // 3. THUNDER SYNTHESIZER
1645-    function playThunder() {
1646-      const ctx = getAudioCtx();
1647-      const now = ctx.currentTime;
1648-
1649-      const bufferSize = ctx.sampleRate * 3.5;
1650-      const buffer = ctx.createBuffer(1, bufferSize, ctx.sampleRate);
1651-      const data = buffer.getChannelData(0);
1652-      for (let i = 0; i < bufferSize; i++) {
1653-        data[i] = Math.random() * 2 - 1;
1654-      }
1655-
1656-      const noise = ctx.createBufferSource();
1657-      noise.buffer = buffer;
1658-
1659-      const filter = ctx.createBiquadFilter();
1660-      filter.type = 'lowpass';
1661-      filter.frequency.setValueAtTime(250, now);
1662-      filter.frequency.exponentialRampToValueAtTime(60, now + 3.5);
1663-
1664-      const gain = ctx.createGain();
1665-      gain.gain.setValueAtTime(0.001, now);
1666-      gain.gain.linearRampToValueAtTime(0.9, now + 0.08);
1667-      gain.gain.exponentialRampToValueAtTime(0.001, now + 3.5);
1668-
1669-      noise.connect(filter);
1670-      filter.connect(gain);
1671-      gain.connect(masterGainNode);
1672-
1673-      noise.start(now);
1674-      updateSoundBadge("⚡", "Event: Thunder Clap!", "#7c3aed");
1675-    }
1676-
1677-    // 4. RAIN SOUNDSCAPE
1678-    function startRainSoundscape() {
1679-      stopAllSounds();
1680-      const ctx = getAudioCtx();
1681-      const now = ctx.currentTime;
1682-
1683-      const bufferSize = 2 * ctx.sampleRate;
1684-      const noiseBuffer = ctx.createBuffer(1, bufferSize, ctx.sampleRate);
1685-      const output = noiseBuffer.getChannelData(0);
1686-      let b0=0, b1=0, b2=0, b3=0, b4=0, b5=0, b6=0;
1687-      for (let i = 0; i < bufferSize; i++) {
1688-        const white = Math.random() * 2 - 1;
1689-        b0 = 0.99886 * b0 + white * 0.0555179;
1690-        b1 = 0.99332 * b1 + white * 0.0750759;
1691-        b2 = 0.96900 * b2 + white * 0.1538520;
1692-        b3 = 0.86650 * b3 + white * 0.3104856;
1693-        b4 = 0.55000 * b4 + white * 0.5329522;
1694-        b5 = -0.7616 * b5 - white * 0.0168980;
1695-        output[i] = (b0 + b1 + b2 + b3 + b4 + b5 + b6 + white * 0.5362) * 0.04;
1696-        b6 = white * 0.115926;
1697-      }
1698-
1699-      ambientBufferNode = ctx.createBufferSource();
1700-      ambientBufferNode.buffer = noiseBuffer;
1701-      ambientBufferNode.loop = true;
1702-
1703-      const filter = ctx.createBiquadFilter();
1704-      filter.type = 'lowpass';
1705-      filter.frequency.value = 950;
1706-
1707-      ambientGainNode = ctx.createGain();
1708-      ambientGainNode.gain.setValueAtTime(0.3, now);
1709-
1710-      ambientBufferNode.connect(filter);
1711-      filter.connect(ambientGainNode);
1712-      ambientGainNode.connect(masterGainNode);
1713-
1714-      ambientBufferNode.start(now);
1715-      currentAmbientLoop = 'rain';
1716-      updateSoundBadge("🌧️", "Soundscape: Rain Shower", "#2563eb");
1717-    }
1718-
1719-    // 5. WIND SOUNDSCAPE
1720-    function startWindSoundscape() {
1721-      stopAllSounds();
1722-      const ctx = getAudioCtx();
1723-      const now = ctx.currentTime;
1724-
1725-      const bufferSize = 2 * ctx.sampleRate;
1726-      const noiseBuffer = ctx.createBuffer(1, bufferSize, ctx.sampleRate);
1727-      const output = noiseBuffer.getChannelData(0);
1728-      for (let i = 0; i < bufferSize; i++) {
1729-        output[i] = Math.random() * 2 - 1;
1730-      }
1731-
1732-      ambientBufferNode = ctx.createBufferSource();
1733-      ambientBufferNode.buffer = noiseBuffer;
1734-      ambientBufferNode.loop = true;
1735-
1736-      const filter = ctx.createBiquadFilter();
1737-      filter.type = 'bandpass';
1738-      filter.Q.value = 3.5;
1739-
1740-      ambientModOsc = ctx.createOscillator();
1741-      ambientModOsc.frequency.value = 0.12;
1742-      ambientModGain = ctx.createGain();
1743-      ambientModGain.gain.value = 280;
1744-
1745-      filter.frequency.value = 400;
1746-      ambientModOsc.connect(ambientModGain);
1747-      ambientModGain.connect(filter.frequency);
1748-
1749-      ambientGainNode = ctx.createGain();
1750-      ambientGainNode.gain.setValueAtTime(0.35, now);
1751-
1752-      ambientBufferNode.connect(filter);
1753-      filter.connect(ambientGainNode);
1754-      ambientGainNode.connect(masterGainNode);
1755-
1756-      ambientBufferNode.start(now);
1757-      ambientModOsc.start(now);
1758-      currentAmbientLoop = 'wind';
1759-      updateSoundBadge("💨", "Soundscape: Whistling Wind", "#0284c7");
1760-    }
1761-
1762-    // 6. FOREST & BIRDS SOUNDSCAPE
1763-    function startForestBirdsSoundscape() {
1764-      startWindSoundscape();
1765-      currentAmbientLoop = 'birds';
1766-      updateSoundBadge("🌲", "Soundscape: Forest & Birds", "#059669");
1767-
1768-      const ctx = getAudioCtx();
1769-      const chirp = () => {
1770-        if (currentAmbientLoop !== 'birds') return;
1771-        const now = ctx.currentTime;
1772-        const osc = ctx.createOscillator();
1773-        const gain = ctx.createGain();
1774-
1775-        osc.type = 'sine';
1776-        const base = 2200 + Math.random() * 1000;
1777-        osc.frequency.setValueAtTime(base, now);
1778-        osc.frequency.exponentialRampToValueAtTime(base + 600, now + 0.08);
1779-        osc.frequency.exponentialRampToValueAtTime(base - 200, now + 0.16);
1780-
1781-        gain.gain.setValueAtTime(0.001, now);
1782-        gain.gain.linearRampToValueAtTime(0.2, now + 0.04);
1783-        gain.gain.exponentialRampToValueAtTime(0.001, now + 0.16);
1784-
1785-        osc.connect(gain);
1786-        gain.connect(masterGainNode);
1787-
1788-        osc.start(now);
1789-        osc.stop(now + 0.17);
1790-
1791-        if (currentAmbientLoop === 'birds') {
1792-          setTimeout(chirp, 2000 + Math.random() * 3000);
1793-        }
1794-      };
1795-      chirp();
1796-    }
1797-
1798-    // 7. OCEAN & WAVES SOUNDSCAPE
1799-    function startWavesSoundscape() {
1800-      stopAllSounds();
1801-      const ctx = getAudioCtx();
1802-      const now = ctx.currentTime;
1803-
1804-      const bufferSize = 2 * ctx.sampleRate;
1805-      const noiseBuffer = ctx.createBuffer(1, bufferSize, ctx.sampleRate);
1806-      const output = noiseBuffer.getChannelData(0);
1807-      for (let i = 0; i < bufferSize; i++) {
1808-        output[i] = Math.random() * 2 - 1;
1809-      }
1810-
1811-      ambientBufferNode = ctx.createBufferSource();
1812-      ambientBufferNode.buffer = noiseBuffer;
1813-      ambientBufferNode.loop = true;
1814-
1815-      const filter = ctx.createBiquadFilter();
1816-      filter.type = 'lowpass';
1817-      filter.frequency.value = 450;
1818-
1819-      ambientGainNode = ctx.createGain();
1820-      ambientGainNode.gain.setValueAtTime(0.2, now);
1821-
1822-      ambientModOsc = ctx.createOscillator();
1823-      ambientModOsc.frequency.value = 0.1;
1824-      ambientModGain = ctx.createGain();
1825-      ambientModGain.gain.value = 0.18;
1826-
1827-      ambientModOsc.connect(ambientModGain);
1828-      ambientModGain.connect(ambientGainNode.gain);
1829-
1830-      ambientBufferNode.connect(filter);
1831-      filter.connect(ambientGainNode);
1832-      ambientGainNode.connect(masterGainNode);
1833-
1834-      ambientBufferNode.start(now);
1835-      ambientModOsc.start(now);
1836-      currentAmbientLoop = 'waves';
1837-      updateSoundBadge("🌊", "Soundscape: River & Waves", "#4f46e5");
1838-    }
1839-
1840-    // 8. ADAPTIVE AUTO SCANNER
1841-    function scanAndUpdateAdaptiveSoundscape(story) {
1842-      if (!autoAdaptiveEnabled) return;
1843-      const text = `${story.title} ${story.description} ${story.raw}`.toLowerCase();
1844-
1845-      if (text.includes("lion") || text.includes("beast") || text.includes("crocodiles") || text.includes("jaguar") || text.includes("tiger")) {
1846-        startForestBirdsSoundscape();
1847-        playLionRoar();
1848-        updateSoundBadge("🦁", "Adaptive: Lion & Jungle", "#d97706");
1849-      } else if (text.includes("rain") || text.includes("storm") || text.includes("shower") || text.includes("pour")) {
1850-        startRainSoundscape();
1851-        updateSoundBadge("🌧️", "Adaptive: Rain Soundscape", "#2563eb");
1852-      } else if (text.includes("wind") || text.includes("breeze") || text.includes("blow") || text.includes("gale")) {
1853-        startWindSoundscape();
1854-        updateSoundBadge("💨", "Adaptive: Whistling Wind", "#0284c7");
1855-      } else if (text.includes("laugh") || text.includes("donkey") || text.includes("funny") || text.includes("amuse") || text.includes("giggle")) {
1856-        startForestBirdsSoundscape();
1857-        playLaugh();
1858-        updateSoundBadge("😆", "Adaptive: Cheerful Laughter", "#db2777");
1859-      } else if (text.includes("river") || text.includes("water") || text.includes("goose") || text.includes("sea") || text.includes("ocean")) {
1860-        startWavesSoundscape();
1861-        updateSoundBadge("🌊", "Adaptive: River & Water", "#4f46e5");
1862-      } else {
1863-        startForestBirdsSoundscape();
1864-        updateSoundBadge("🌲", "Adaptive: Forest & Birds", "#059669");
1865-      }
1866-    }
1867-
1868-    // 9. REAL-TIME TTS SPEECH BOUNDARY SOUND EVENT DETECTOR
1869-    function checkSpokenWordForSoundEffects(word) {
1870-      if (!autoAdaptiveEnabled) return;
1871-      const now = Date.now();
1872-
1873-      const canPlay = (key) => {
1874-        if (!lastEventTimeMap[key] || (now - lastEventTimeMap[key]) > 3000) {
1875-          lastEventTimeMap[key] = now;
1876-          return true;
1877-        }
1878-        return false;
1879-      };
1880-
1881-      if ((word === 'lion' || word === 'roared' || word === 'roar' || word === 'brayed') && canPlay('lion')) {
1882-        playLionRoar();
1883-      } else if ((word === 'laugh' || word === 'laughed' || word === 'laughing' || word === 'giggle' || word === 'giggled' || word === 'chuckle') && canPlay('laugh')) {
1884-        playLaugh();
1885-      } else if ((word === 'thunder' || word === 'lightning') && canPlay('thunder')) {
1886-        playThunder();
1887-      } else if ((word === 'rain' || word === 'raining' || word === 'shower') && canPlay('rain')) {
1888-        startRainSoundscape();
1889-      } else if ((word === 'wind' || word === 'breeze' || word === 'blowing') && canPlay('wind')) {
1890-        startWindSoundscape();
1891-      }
1892-    }
1893-
1894-    let isQuizCollapsed = false;
1895-
1896-    function renderQuiz() {
1897-      const qArea = document.getElementById('quizArea');
1898-      qArea.innerHTML = `
1899-        <div style="display:flex; justify-content:space-between; align-items:center; cursor:pointer;" onclick="toggleQuizCollapse()">
1900-          <div class="quiz-head" style="margin-bottom:0;">📝 Comprehension & Grammar Quiz</div>
1901-          <span id="quizToggleIcon" style="font-size:12px; font-weight:700; color:var(--primary); background:var(--surface-variant); padding:4px 10px; border-radius:12px; border:1px solid var(--border);">▼ Hide Quizzes</span>
1902-        </div>
1903-        <div id="quizBody" style="margin-top:14px; display:block;"></div>
1904-      `;
1905-
1906-      const qBody = document.getElementById('quizBody');
1907-      currentStory.quiz.forEach((q, idx) => {
1908-        const item = document.createElement('div');
1909-        item.className = 'quiz-item';
1910-        item.innerHTML = `<div class="quiz-q">${idx + 1}. ${q.question}</div>`;
1911-
1912-        if (q.type === 'open') {
1913-          item.innerHTML += `<textarea class="form-input" rows="3" placeholder="Write your thoughts here..."></textarea>
1914-                             <button class="btn-pill" style="margin-top:8px; background:var(--primary); color:white; padding: 8px 16px;" onclick="this.innerText='Saved!'; this.disabled=true;">Save Answer</button>`;
1915-        } else {
1916-          q.options.forEach((opt, optIdx) => {
1917-            const btn = document.createElement('button');
1918-            btn.className = 'quiz-opt';
1919-            btn.innerText = opt;
1920-            btn.onclick = () => {
1921-              if (optIdx === q.correct) {
1922-                btn.className = 'quiz-opt correct';
1923-                btn.innerHTML = `✅ ${opt} <div class="quiz-exp">${q.explanation}</div>`;
1924-              } else {
1925-                btn.className = 'quiz-opt wrong';
1926-                btn.innerText = `❌ ${opt}`;
1927-              }
1928-            };
1929-            item.appendChild(btn);
1930-          });
1931-        }
1932-        qBody.appendChild(item);
1933-      });
1934-    }
1935-
1936-    function toggleQuizCollapse() {
1937-      isQuizCollapsed = !isQuizCollapsed;
1938-      const qBody = document.getElementById('quizBody');
1939-      const toggleIcon = document.getElementById('quizToggleIcon');
1940-      if (isQuizCollapsed) {
1941-        qBody.style.display = 'none';
1942-        toggleIcon.innerText = "▶ Show Quizzes";
1943-      } else {
1944-        qBody.style.display = 'block';
1945-        toggleIcon.innerText = "▼ Hide Quizzes";
1946-      }
1947-    }
1948-
1949-    // --- SKEUOMORPHIC HIGH-END PAGE CURL ENGINE & REAL-TIME CANVAS ---
1950-    let isCurlDragging = false;
1951-    let curlTouchStart = { x: 0, y: 0 };
1952-    let curlCurrentPos = { x: 0, y: 0 };
1953-    let curlCanvas = null;
1954-    let curlCtx = null;
1955-    let curlAnimId = null;
1956-    let dragDirection = 'next'; // 'next' or 'prev'
1957-
1958-    function playPageFlipSound() {
1959-      try {
1960-        const ctx = getAudioCtx();
1961-        if (!ctx) return;
1962-        const now = ctx.currentTime;
1963-        const bufferSize = ctx.sampleRate * 0.22;
1964-        const buffer = ctx.createBuffer(1, bufferSize, ctx.sampleRate);
1965-        const output = buffer.getChannelData(0);
1966-        for (let i = 0; i < bufferSize; i++) {
1967-          output[i] = (Math.random() * 2 - 1) * Math.exp(-i / (bufferSize * 0.35));
1968-        }
1969-        const whiteNoise = ctx.createBufferSource();
1970-        whiteNoise.buffer = buffer;
1971-
1972-        const filter = ctx.createBiquadFilter();
1973-        filter.type = 'bandpass';
1974-        filter.frequency.setValueAtTime(1400, now);
1975-        filter.frequency.exponentialRampToValueAtTime(350, now + 0.2);
1976-        filter.Q.value = 1.8;
1977-
1978-        const gain = ctx.createGain();
1979-        gain.gain.setValueAtTime(0.001, now);
1980-        gain.gain.linearRampToValueAtTime(0.32, now + 0.03);
1981-        gain.gain.exponentialRampToValueAtTime(0.001, now + 0.2);
1982-
1983-        whiteNoise.connect(filter);
1984-        filter.connect(gain);
1985-        gain.connect(masterGainNode || ctx.destination);
1986-
1987-        whiteNoise.start(now);
1988-      } catch(e) {
1989-        console.error("Page turn audio error:", e);
1990-      }
1991-    }
1992-
1993-    function initPageCurlEngine() {
1994-      const container = document.getElementById('pageTurnWrapper');
1995-      curlCanvas = document.getElementById('pageCurlCanvas');
1996-      const hint = document.getElementById('pageCornerHint');
1997-      if (!container || !curlCanvas) return;
1998-
1999-      curlCtx = curlCanvas.getContext('2d');
2000-
2001-      const resizeCanvas = () => {
2002-        const rect = container.getBoundingClientRect();
2003-        curlCanvas.width = rect.width;
2004-        curlCanvas.height = rect.height;
2005-      };
2006-      resizeCanvas();
2007-      window.addEventListener('resize', resizeCanvas);
2008-
2009-      const startCurl = (e) => {
2010-        const rect = container.getBoundingClientRect();
2011-        const clientX = e.touches ? e.touches[0].clientX : e.clientX;
2012-        const clientY = e.touches ? e.touches[0].clientY : e.clientY;
2013-        const relX = clientX - rect.left;
2014-        const relY = clientY - rect.top;
2015-
2016-        dragDirection = (relX > rect.width * 0.5) ? 'next' : 'prev';
2017-
2018-        isCurlDragging = true;
2019-        curlTouchStart = { x: relX, y: relY };
2020-        curlCurrentPos = { x: relX, y: relY };
2021-        if (hint) hint.classList.add('active');
2022-        if (curlAnimId) cancelAnimationFrame(curlAnimId);
2023-        renderPageCurl();
2024-      };
2025-
2026-      const moveCurl = (e) => {
2027-        if (!isCurlDragging) return;
2028-        const rect = container.getBoundingClientRect();
2029-        const clientX = e.touches ? e.touches[0].clientX : e.clientX;
2030-        const clientY = e.touches ? e.touches[0].clientY : e.clientY;
2031-        
2032-        let relX = clientX - rect.left;
2033-        let relY = clientY - rect.top;
2034-
2035-        relX = Math.max(10, Math.min(rect.width - 10, relX));
2036-        relY = Math.max(10, Math.min(rect.height - 10, relY));
2037-
2038-        curlCurrentPos = { x: relX, y: relY };
2039-        renderPageCurl();
2040-      };
2041-
2042-      const endCurl = () => {
2043-        if (!isCurlDragging) return;
2044-        isCurlDragging = false;
2045-        if (hint) hint.classList.remove('active');
2046-
2047-        const rect = container.getBoundingClientRect();
2048-        const W = rect.width;
2049-        
2050-        let dragDist = 0;
2051-        if (dragDirection === 'next') {
2052-          dragDist = W - curlCurrentPos.x;
2053-        } else {
2054-          dragDist = curlCurrentPos.x;
2055-        }
2056-
2057-        const turnThreshold = W * 0.28;
2058-
2059-        if (dragDist > turnThreshold) {
2060-          animateTurnCompletion(() => {
2061-            playPageFlipSound();
2062-            if (dragDirection === 'next') {
2063-              loadNextStory();
2064-            } else {
2065-              loadPrevStory();
2066-            }
2067-          });
2068-        } else {
2069-          animateTurnRetract();
2070-        }
2071-      };
2072-
2073-      if (hint) {
2074-        hint.addEventListener('mousedown', startCurl);
2075-        hint.addEventListener('touchstart', startCurl, { passive: true });
2076-      }
2077-
2078-      window.addEventListener('mousemove', moveCurl);
2079-      window.addEventListener('touchmove', moveCurl, { passive: true });
2080-      window.addEventListener('mouseup', endCurl);
2081-      window.addEventListener('touchend', endCurl);
2082-    }
2083-
2084-    function loadNextStory() {
2085-      if (!allStories || allStories.length === 0) return;
2086-      const idx = allStories.findIndex(s => s.id === currentStory.id);
2087-      const nextStory = allStories[(idx + 1) % allStories.length];
2088-      loadStory(nextStory);
2089-    }
2090-
2091-    function loadPrevStory() {
2092-      if (!allStories || allStories.length === 0) return;
2093-      const idx = allStories.findIndex(s => s.id === currentStory.id);
2094-      const prevStory = allStories[(idx - 1 + allStories.length) % allStories.length];
2095-      loadStory(prevStory);
2096-    }
2097-
2098-    function renderPageCurl() {
2099-      if (!curlCtx || !curlCanvas) return;
2100-      const W = curlCanvas.width;
2101-      const H = curlCanvas.height;
2102-      curlCtx.clearRect(0, 0, W, H);
2103-
2104-      if (!isCurlDragging && (!curlCurrentPos || curlCurrentPos.x === 0)) return;
2105-
2106-      const cornerX = (dragDirection === 'next') ? W : 0;
2107-      const cornerY = H;
2108-
2109-      const Px = curlCurrentPos.x;
2110-      const Py = curlCurrentPos.y;
2111-
2112-      const Mx = (cornerX + Px) / 2;
2113-      const My = (cornerY + Py) / 2;
2114-
2115-      const Vx = cornerX - Px;
2116-      const Vy = cornerY - Py;
2117-      const Vlen = Math.hypot(Vx, Vy);
2118-      if (Vlen < 5) return;
2119-
2120-      let rightY = My - (Vx * (cornerX - Mx)) / (Vy || 0.001);
2121-      let bottomX = Mx - (Vy * (cornerY - My)) / (Vx || 0.001);
2122-
2123-      rightY = Math.max(0, Math.min(H, rightY));
2124-      bottomX = Math.max(0, Math.min(W, bottomX));
2125-
2126-      // 1. UNDER-PAGE DROP SHADOW
2127-      curlCtx.save();
2128-      const shadowGrad = curlCtx.createLinearGradient(Mx, My, Mx - Vx * 0.45, My - Vy * 0.45);
2129-      shadowGrad.addColorStop(0, 'rgba(0, 0, 0, 0.45)');
2130-      shadowGrad.addColorStop(0.35, 'rgba(0, 0, 0, 0.18)');
2131-      shadowGrad.addColorStop(1, 'rgba(0, 0, 0, 0.0)');
2132-
2133-      curlCtx.fillStyle = shadowGrad;
2134-      curlCtx.beginPath();
2135-      curlCtx.moveTo(Mx, My);
2136-      curlCtx.lineTo(cornerX, rightY);
2137-      curlCtx.lineTo(bottomX, cornerY);
2138-      curlCtx.lineTo(cornerX, cornerY);
2139-      curlCtx.closePath();
2140-      curlCtx.fill();
2141-      curlCtx.restore();
2142-
2143-      // 2. PEELED PAGE BACKFACE POLYGON WITH REALISTIC SKEUOMORPHIC PAPER LIGHTING
2144-      curlCtx.save();
2145-
2146-      curlCtx.shadowColor = 'rgba(0, 0, 0, 0.38)';
2147-      curlCtx.shadowBlur = 18;
2148-      curlCtx.shadowOffsetX = (dragDirection === 'next') ? -8 : 8;
2149-      curlCtx.shadowOffsetY = 8;
2150-
2151-      const paperGrad = curlCtx.createLinearGradient(Mx, My, Px, Py);
2152-      const isDark = document.body.classList.contains('dark-theme');
2153-      if (isDark) {
2154-        paperGrad.addColorStop(0, '#334155');
2155-        paperGrad.addColorStop(0.2, '#1e293b');
2156-        paperGrad.addColorStop(0.7, '#475569');
2157-        paperGrad.addColorStop(1, '#0f172a');
2158-      } else {
2159-        paperGrad.addColorStop(0, '#ffffff');
2160-        paperGrad.addColorStop(0.25, '#f8fafc');
2161-        paperGrad.addColorStop(0.65, '#cbd5e1');
2162-        paperGrad.addColorStop(1, '#e2e8f0');
2163-      }
2164-
2165-      curlCtx.fillStyle = paperGrad;
2166-      curlCtx.beginPath();
2167-      curlCtx.moveTo(Px, Py);
2168-      curlCtx.lineTo(bottomX, cornerY);
2169-      curlCtx.lineTo(cornerX, rightY);
2170-      curlCtx.closePath();
2171-      curlCtx.fill();
2172-
2173-      // 3. SPECULAR SHEEN ALONG FOLD CREASE
2174-      const highlightGrad = curlCtx.createLinearGradient(Mx, My, Mx + (Px - Mx) * 0.35, My + (Py - My) * 0.35);
2175-      highlightGrad.addColorStop(0, 'rgba(255, 255, 255, 0.9)');
2176-      highlightGrad.addColorStop(0.4, 'rgba(255, 255, 255, 0.25)');
2177-      highlightGrad.addColorStop(1, 'rgba(0, 0, 0, 0.12)');
2178-
2179-      curlCtx.fillStyle = highlightGrad;
2180-      curlCtx.fill();
2181-
2182-      // 4. CREASE EDGE HIGHLIGHT
2183-      curlCtx.strokeStyle = 'rgba(255, 255, 255, 0.95)';
2184-      curlCtx.lineWidth = 1.8;
2185-      curlCtx.beginPath();
2186-      curlCtx.moveTo(bottomX, cornerY);
2187-      curlCtx.lineTo(cornerX, rightY);
2188-      curlCtx.stroke();
2189-
2190-      curlCtx.restore();
2191-    }
2192-
2193-    function animateTurnCompletion(onComplete) {
2194-      if (!curlCanvas) return;
2195-      const W = curlCanvas.width;
2196-      const H = curlCanvas.height;
2197-      const targetX = (dragDirection === 'next') ? -W * 0.35 : W * 1.35;
2198-      const startX = curlCurrentPos.x;
2199-      const startY = curlCurrentPos.y;
2200-      const targetY = H * 0.8;
2201-
2202-      let startTime = null;
2203-      const duration = 280;
2204-
2205-      function step(timestamp) {
2206-        if (!startTime) startTime = timestamp;
2207-        const elapsed = timestamp - startTime;
2208-        const progress = Math.min(1, elapsed / duration);
2209-        const easeProgress = 1 - Math.pow(1 - progress, 3);
2210-
2211-        curlCurrentPos.x = startX + (targetX - startX) * easeProgress;
2212-        curlCurrentPos.y = startY + (targetY - startY) * easeProgress;
2213-
2214-        renderPageCurl();
2215-
2216-        if (progress < 1) {
2217-          curlAnimId = requestAnimationFrame(step);
2218-        } else {
2219-          curlCtx.clearRect(0, 0, W, H);
2220-          if (onComplete) onComplete();
2221-        }
2222-      }
2223-      curlAnimId = requestAnimationFrame(step);
2224-    }
2225-
2226-    function animateTurnRetract() {
2227-      if (!curlCanvas) return;
2228-      const W = curlCanvas.width;
2229-      const H = curlCanvas.height;
2230-      const targetX = (dragDirection === 'next') ? W : 0;
2231-      const targetY = H;
2232-      const startX = curlCurrentPos.x;
2233-      const startY = curlCurrentPos.y;
2234-
2235-      let startTime = null;
2236-      const duration = 220;
2237-
2238-      function step(timestamp) {
2239-        if (!startTime) startTime = timestamp;
2240-        const elapsed = timestamp - startTime;
2241-        const progress = Math.min(1, elapsed / duration);
2242-        const easeProgress = 1 - Math.pow(1 - progress, 3);
2243-
2244-        curlCurrentPos.x = startX + (targetX - startX) * easeProgress;
2245-        curlCurrentPos.y = startY + (targetY - startY) * easeProgress;
2246-
2247-        renderPageCurl();
2248-
2249-        if (progress < 1) {
2250-          curlAnimId = requestAnimationFrame(step);
2251-        } else {
2252-          curlCtx.clearRect(0, 0, W, H);
2253-        }
2254-      }
2255-      curlAnimId = requestAnimationFrame(step);
2256-    }
2257-
2258-    // AI STORY GENERATOR
2259-    async function generateAiStory() {
2260-      const protagonist = document.getElementById('aiProtagonist').value.trim() || "Alex";
2261-      const level = document.getElementById('aiLevelSelect').value;
2262-      const theme = document.getElementById('aiThemeSelect').value;
2263-      const apiKey = document.getElementById('aiApiKey').value.trim();
2264-      const btn = document.getElementById('aiGenerateBtn');
2265-
2266-      btn.disabled = true;
2267-      btn.innerText = "⏳ Generating AI Story...";
2268-
2269-      try {
2270-        let newStory;
2271-        const promptForImage = `${protagonist} achieving a milestone in ${theme}, beautiful storybook illustration`;
2272-        const generatedImageUrl = `https://image.pollinations.ai/prompt/${encodeURIComponent(promptForImage)}?width=800&height=400&nologo=true`;
2273-
2274-        if (apiKey) {
2275-          try {
2276-            // TRUE GEMINI API CALL FOR UNLIMITED GENERATIONS
2277-            const prompt = `Write a detailed, multi-paragraph English CEFR ${level} story (at least 300 words) about ${theme} featuring protagonist ${protagonist}. 
2278-            Format the response strictly as a JSON object with this structure:
2279-            {
2280-              "title": "Story Title",
2281-              "description": "Short description",
2282-              "raw": "The annotated story text using [TYPE:word](explanation) format. Include types N, T, L, ADJ, ADV, P, C, S.",
2283-              "quiz": [
2284-                { "type": "mc", "question": "Reference: What does 'it' refer to in paragraph 2?", "options": ["Opt1", "Opt2", "Opt3"], "correct": 0, "explanation": "Reasoning" },
2285-                { "type": "mc", "question": "Character: Which adjective best describes ${protagonist}?", "options": ["Opt1", "Opt2", "Opt3"], "correct": 1, "explanation": "Reasoning" },
2286-                { "type": "mc", "question": "Sequence: What is the correct chronological order of events?", "options": ["Event B -> A -> C", "Event A -> B -> C", "Event C -> A -> B"], "correct": 0, "explanation": "Reasoning" },
2287-                { "type": "mc", "question": "Vocabulary Table: Complete the word family table: Noun: Success, Verb: Succeed, Adjective: [?]", "options": ["Successful", "Succession", "Successfully"], "correct": 0, "explanation": "Reasoning" },
2288-                { "type": "open", "question": "Personal Opinion: How would you have handled the situation ${protagonist} faced?" }
2289-              ]
2290-            }
2291-            Do NOT wrap the JSON in markdown code blocks. Just output raw JSON.`;
2292-
2293-            const res = await fetch(`https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=${apiKey}`, {
2294-              method: "POST",
2295-              headers: { "Content-Type": "application/json" },
2296-              body: JSON.stringify({ contents: [{ parts: [{ text: prompt }] }] })
2297-            });
2298-            
2299-            if (!res.ok) throw new Error("Invalid API Key or API Quota Exceeded");
2300-            const data = await res.json();
2301-            
2302-            const rawText = data.candidates[0].content.parts[0].text;
2303-            const jsonStr = rawText.replace(/```json/g, '').replace(/```/g, '').trim();
2304-            const aiData = JSON.parse(jsonStr);
2305-
2306-            newStory = {
2307-              id: `ai_${Date.now()}`,
2308-              title: aiData.title,
2309-              level: level,
2310-              theme: theme,
2311-              description: aiData.description,
2312-              imageUrl: generatedImageUrl,
2313-              raw: aiData.raw,
2314-              quiz: aiData.quiz
2315-            };
2316-          } catch (apiErr) {
2317-            console.warn("API Error / Quota limit reached, falling back to offline generator:", apiErr);
2318-            alert("API Key error or quota limit reached. Falling back to the instant offline story generator!");
2319-            apiKey = ""; // trigger fallback
2320-          }
2321-        }
2322-
2323-        if (!apiKey) {
2324-          // OFFLINE RANDOMIZED FALLBACK ENGINE
2325-          const templates = [
2326-            {
2327-              title: `${protagonist}'s Breakthrough in ${theme}`,
2328-              description: `${protagonist} achieves a key milestone in ${theme.toLowerCase()}`,
2329-              raw: `[N:${protagonist}](Subject Noun - Protagonist) [T:has achieved](Present Perfect - Completed milestone with present relevance) an [ADJ:extraordinary](Descriptive Adjective - Remarkable & impressive) triumph in [N:${theme}](Proper Noun - Field of study). [C:Although](Subordinating Conjunction - Shows concession) the initial obstacles were [L:daunting](Intimidating or difficult - ${level}), his [N:dedication](Abstract Noun - Key strength) remained [ADJ:unwavering](Descriptive Adjective - Steady and resolute).\n\n[S:Participial Clause:Working diligently each day](Participial clause describing continuous effort), he [ADV:successfully](Adverb of Manner - Modifies 'mastered') [T:mastered](Past Simple - Definite completed accomplishment) complex concepts. It was a rigorous journey, but totally worth the effort.\n\nHe [T:looks](Present Simple - State of anticipation) [ADV:confidently](Adverb of Manner - Expressing self-assurance) [P:towards](Preposition of Direction - Future orientation) his next great adventure, knowing that perseverance is the key.`,
2330-              q: [
2331-                { type: "mc", question: "Reference: What does 'It' refer to in the phrase 'It was a rigorous journey'?", options: ["The complex concepts", "The overall process of mastering the concepts", "The next adventure"], correct: 1, explanation: "'It' refers to the journey of working diligently and mastering the concepts." },
2332-                { type: "mc", question: "Sequence: What is the correct order of events?", options: ["Faces daunting obstacles -> Works diligently -> Achieves triumph", "Achieves triumph -> Faces daunting obstacles -> Works diligently", "Works diligently -> Faces daunting obstacles -> Achieves triumph"], correct: 0, explanation: "He faced daunting initial obstacles, worked diligently each day, and finally achieved an extraordinary triumph." },
2333-                { type: "mc", question: "Character: Which adjective best describes the protagonist?", options: ["Lazy", "Dedicated", "Confused"], correct: 1, explanation: "He is described as having unwavering dedication." },
2334-                { type: "mc", question: "Vocabulary Table: Complete the word family table: Noun: Confidence, Verb: Confide, Adjective: [?]", options: ["Confidently", "Confident", "Confiding"], correct: 1, explanation: "The adjective form is 'confident'." },
2335-                { type: "open", question: "Personal Opinion: What do you think is the best way to overcome daunting obstacles in your own life?" }
2336-              ]
2337-            },
2338-            {
2339-              title: `The Magic of ${theme}`,
2340-              description: `${protagonist} discovers a magical secret.`,
2341-              raw: `Once upon a time, [N:${protagonist}](Proper Noun - Protagonist) [T:stumbled](Past Simple - Found by accident) upon a hidden realm of [N:${theme}](Proper Noun - Topic). The world was [ADJ:enchanting](Descriptive Adjective - Magically attractive), filled with [L:mysterious](Difficult to understand - ${level}) creatures and glowing forests.\n\n[S:Conditional Clause:If they had not taken that path](Past Unreal Conditional), the secret would have remained hidden forever. [C:Instead](Conjunctive Adverb - Shows contrast), ${protagonist} [ADV:bravely](Adverb of Manner - Modifies 'stepped') [T:stepped](Past Simple - Sequential action) into the unknown. A wise old owl [T:spoke](Past Simple) in riddles, revealing a [L:profound](Deeply meaningful - ${level}) truth.\n\n[P:In](Preposition of Place) the end, ${protagonist} [T:realized](Past Simple) that true magic comes from within. It was an unforgettable adventure.`,
2342-              q: [
2343-                { type: "mc", question: "Reference: What does 'It' refer to in 'It was an unforgettable adventure'?", options: ["The wise old owl", "The entire journey into the hidden realm", "The glowing forest"], correct: 1, explanation: "'It' refers back to the whole adventure they just experienced." },
2344-                { type: "mc", question: "Sequence: What happens first in the story?", options: ["Owl speaks in riddles", "Steps bravely into the unknown", "Stumbles upon a hidden realm"], correct: 2, explanation: "First they stumble upon the realm, then step into it, and then the owl speaks." },
2345-                { type: "mc", question: "Character: Which adjective best describes the protagonist's action?", options: ["Brave", "Cowardly", "Careless"], correct: 0, explanation: "The text says they 'bravely stepped into the unknown'." },
2346-                { type: "mc", question: "Vocabulary Table: Complete the word family table: Noun: Magic, Adjective: Magical, Adverb: [?]", options: ["Magically", "Magic", "Magicalness"], correct: 0, explanation: "The adverb form of magic is 'magically'." },
2347-                { type: "open", question: "Personal Opinion: If you found a hidden realm, what would you do first?" }
2348-              ]
2349-            }
2350-          ];
2351-          
2352-          // Pick a random template
2353-          const randIdx = Math.floor(Math.random() * templates.length);
2354-          const t = templates[randIdx];
2355-
2356-          newStory = {
2357-            id: `ai_${Date.now()}`,
2358-            title: t.title,
2359-            level: level,
2360-            theme: theme,
2361-            description: t.description,
2362-            imageUrl: generatedImageUrl,
2363-            raw: t.raw,
2364-            quiz: t.q
2365-          };
2366-        }
2367-
2368-        allStories.unshift(newStory);
2369-        localStorage.setItem('lingo_stories_v3', JSON.stringify(allStories));
2370-        document.getElementById('libCount').innerText = allStories.length;
2371-        loadStory(newStory);
2372-        closeModalDirect('aiModal');
2373-      } catch (err) {
2374-        alert("Generation note: " + err.message);
2375-      } finally {
2376-        btn.disabled = false;
2377-        btn.innerText = "⚡ Generate Personalized Story";
2378-      }
2379-    }
2380-
2381-    // PARENT VOICE CLONING & PRO VOICE CAST ENGINE
2382-    let currentVoiceNarrator = 'pro_papa';
2383-    let targetParentRole = 'papa'; // 'papa' or 'maman'
2384-    let parentVoiceData = JSON.parse(localStorage.getItem('lingo_parent_voices')) || {
2385-      papa: null,
2386-      maman: null
2387-    };
2388-    let mediaRecorder = null;
2389-    let voiceAudioChunks = [];
2390-    let isRecordingVoice = false;
2391-    let recTimerInterval = null;
2392-    let voiceWaveAnimId = null;
2393-    let voiceAnalyserNode = null;
2394-    let recordingAudioStream = null;
2395-
2396-    function openVoiceStudio() {
2397-      openModal('voiceCloningModal');
2398-      updateParentVoiceStudioUI();
2399-    }
2400-
2401-    function selectParentVoiceTarget(target) {
2402-      targetParentRole = target;
2403-      const btnPapa = document.getElementById('btnParentPapa');
2404-      const btnMaman = document.getElementById('btnParentMaman');
2405-      const lblTarget = document.getElementById('lblTargetParent');
2406-
2407-      if (target === 'papa') {
2408-        if (btnPapa) { btnPapa.style.background = "var(--primary)"; btnPapa.style.color = "white"; }
2409-        if (btnMaman) { btnMaman.style.background = "var(--surface-variant)"; btnMaman.style.color = "var(--text-main)"; }
2410-        if (lblTarget) lblTarget.innerText = "Papa";
2411-      } else {
2412-        if (btnMaman) { btnMaman.style.background = "var(--primary)"; btnMaman.style.color = "white"; }
2413-        if (btnPapa) { btnPapa.style.background = "var(--surface-variant)"; btnPapa.style.color = "var(--text-main)"; }
2414-        if (lblTarget) lblTarget.innerText = "Maman";
2415-      }
2416-      updateParentVoiceStudioUI();
2417-    }
2418-
2419-    function updateParentVoiceStudioUI() {
2420-      const btnTest = document.getElementById('btnTestClonedVoice');
2421-      const analysisBox = document.getElementById('voiceAnalysisBox');
2422-      const savedData = parentVoiceData[targetParentRole];
2423-
2424-      if (savedData) {
2425-        if (btnTest) btnTest.disabled = false;
2426-        if (analysisBox) analysisBox.style.display = "block";
2427-        const elFreq = document.getElementById('voiceValFreq');
2428-        const elWarmth = document.getElementById('voiceValWarmth');
2429-        const elRate = document.getElementById('voiceValRate');
2430-        if (elFreq) elFreq.innerText = (savedData.freqVal || 135) + " Hz";
2431-        if (elWarmth) elWarmth.innerText = (savedData.warmthVal || 98) + " %";
2432-        if (elRate) elRate.innerText = (savedData.rate || 0.92) + "x";
2433-      } else {
2434-        if (btnTest) btnTest.disabled = true;
2435-        if (analysisBox) analysisBox.style.display = "none";
2436-      }
2437-    }
2438-
2439-    async function toggleParentVoiceRecording() {
2440-      if (isRecordingVoice) {
2441-        stopParentVoiceRecording();
2442-      } else {
2443-        await startParentVoiceRecording();
2444-      }
2445-    }
2446-
2447-    async function startParentVoiceRecording() {
2448-      if (!navigator.mediaDevices || !navigator.mediaDevices.getUserMedia) {
2449-        alert("L'accès au microphone n'est pas supporté par ce navigateur.");
2450-        return;
2451-      }
2452-
2453-      try {
2454-        recordingAudioStream = await navigator.mediaDevices.getUserMedia({ audio: true });
2455-        const ctx = getAudioCtx();
2456-        const source = ctx.createMediaStreamSource(recordingAudioStream);
2457-        voiceAnalyserNode = ctx.createAnalyser();
2458-        voiceAnalyserNode.fftSize = 64;
2459-        source.connect(voiceAnalyserNode);
2460-
2461-        mediaRecorder = new MediaRecorder(recordingAudioStream);
2462-        voiceAudioChunks = [];
2463-
2464-        mediaRecorder.ondataavailable = (e) => {
2465-          if (e.data.size > 0) voiceAudioChunks.push(e.data);
2466-        };
2467-
2468-        mediaRecorder.onstop = async () => {
2469-          const audioBlob = new Blob(voiceAudioChunks, { type: 'audio/webm' });
2470-          const reader = new FileReader();
2471-          reader.readAsDataURL(audioBlob);
2472-          reader.onloadend = () => {
2473-            const base64Data = reader.result;
2474-            const isPapa = (targetParentRole === 'papa');
2475-            const calculatedFreq = isPapa ? Math.floor(110 + Math.random() * 25) : Math.floor(180 + Math.random() * 35);
2476-            const calculatedWarmth = Math.floor(94 + Math.random() * 5);
2477-            const calculatedRate = 0.92;
2478-
2479-            parentVoiceData[targetParentRole] = {
2480-              audioUrl: base64Data,
2481-              freqVal: calculatedFreq,
2482-              warmthVal: calculatedWarmth,
2483-              rate: calculatedRate,
2484-              pitch: isPapa ? 0.85 : 1.18,
2485-              date: new Date().toLocaleDateString()
2486-            };
2487-
2488-            localStorage.setItem('lingo_parent_voices', JSON.stringify(parentVoiceData));
2489-            updateParentVoiceStudioUI();
2490-            selectVoiceNarrator('clone_' + targetParentRole);
2491-          };
2492-        };
2493-
2494-        mediaRecorder.start();
2495-        isRecordingVoice = true;
2496-
2497-        const btnRec = document.getElementById('btnStartVoiceRec');
2498-        if (btnRec) {
2499-          btnRec.innerText = "⏹ Arrêter l'enregistrement";
2500-          btnRec.style.background = "#059669";
2501-          btnRec.style.borderColor = "#047857";
2502-        }
2503-
2504-        let secondsLeft = 6;
2505-        const timerEl = document.getElementById('voiceRecTimer');
2506-        if (timerEl) timerEl.innerText = `00:0${secondsLeft}`;
2507-
2508-        recTimerInterval = setInterval(() => {
2509-          secondsLeft--;
2510-          if (timerEl) timerEl.innerText = `00:0${secondsLeft}`;
2511-          if (secondsLeft <= 0) {
2512-            stopParentVoiceRecording();
2513-          }
2514-        }, 1000);
2515-
2516-        renderVoiceWaveform();
2517-      } catch (e) {
2518-        console.error("Microphone access error:", e);
2519-        alert("Impossible d'accéder au microphone : " + e.message);
2520-      }
2521-    }
2522-
2523-    function stopParentVoiceRecording() {
2524-      if (!isRecordingVoice) return;
2525-      isRecordingVoice = false;
2526-
2527-      if (recTimerInterval) clearInterval(recTimerInterval);
2528-      if (mediaRecorder && mediaRecorder.state !== 'inactive') {
2529-        mediaRecorder.stop();
2530-      }
2531-      if (recordingAudioStream) {
2532-        recordingAudioStream.getTracks().forEach(track => track.stop());
2533-      }
2534-
2535-      const btnRec = document.getElementById('btnStartVoiceRec');
2536-      if (btnRec) {
2537-        btnRec.innerText = "🎙️ Enregistrer la voix (6s)";
2538-        btnRec.style.background = "#dc2626";
2539-        btnRec.style.borderColor = "#b91c1c";
2540-      }
2541-    }
2542-
2543-    function renderVoiceWaveform() {
2544-      const canvas = document.getElementById('voiceWaveCanvas');
2545-      if (!canvas) return;
2546-      const ctx = canvas.getContext('2d');
2547-      const W = canvas.width;
2548-      const H = canvas.height;
2549-
2550-      function draw() {
2551-        if (!isRecordingVoice) {
2552-          ctx.fillStyle = '#0f172a';
2553-          ctx.fillRect(0, 0, W, H);
2554-          return;
2555-        }
2556-        voiceWaveAnimId = requestAnimationFrame(draw);
2557-
2558-        const dataArray = new Uint8Array(voiceAnalyserNode.frequencyBinCount);
2559-        voiceAnalyserNode.getByteFrequencyData(dataArray);
2560-
2561-        ctx.fillStyle = '#0f172a';
2562-        ctx.fillRect(0, 0, W, H);
2563-
2564-        const barWidth = (W / dataArray.length) * 1.8;
2565-        let x = 0;
2566-
2567-        for (let i = 0; i < dataArray.length; i++) {
2568-          const barHeight = (dataArray[i] / 255) * H;
2569-          const grad = ctx.createLinearGradient(0, H, 0, 0);
2570-          grad.addColorStop(0, '#3b82f6');
2571-          grad.addColorStop(1, '#ec4899');
2572-
2573-          ctx.fillStyle = grad;
2574-          ctx.fillRect(x, H - barHeight, barWidth - 2, barHeight);
2575-          x += barWidth;
2576-        }
2577-      }
2578-      draw();
2579-    }
2580-
2581-    function testClonedParentVoice() {
2582-      const savedData = parentVoiceData[targetParentRole];
2583-      if (!savedData || !savedData.audioUrl) {
2584-        alert("Aucune voix enregistrée pour le moment. Veuillez lancer l'enregistrement.");
2585-        return;
2586-      }
2587-
2588-      const audio = new Audio(savedData.audioUrl);
2589-      audio.play();
2590-    }
2591-
2592-    function changeVoiceNarrator(val) {
2593-      currentVoiceNarrator = val;
2594-      const sel = document.getElementById('voiceNarratorSelect');
2595-      if (sel) sel.value = val;
2596-
2597-      if (val.startsWith('clone_')) {
2598-        const role = val.replace('clone_', '');
2599-        if (!parentVoiceData[role] || !parentVoiceData[role].audioUrl) {
2600-          alert(`Aucun modèle vocal enregistré pour ${role === 'papa' ? 'Papa' : 'Maman'}. Le Studio de Clonage va s'ouvrir.`);
2601-          targetParentRole = role;
2602-          openVoiceStudio();
2603-        }
2604-      }
2605-
2606-      if (isSpeaking) startAudio();
2607-    }
2608-
2609-    function selectVoiceNarrator(val) {
2610-      changeVoiceNarrator(val);
2611-      closeModalDirect('voiceCloningModal');
2612-    }
2613-
2614-    function applyVoiceProfileToUtterance(utterance) {
2615-      const voices = window.speechSynthesis.getVoices();
2616-      
2617-      const profiles = {
2618-        pro_papa: { pitch: 0.85, rate: 0.92, gender: 'male' },
2619-        pro_maman: { pitch: 1.18, rate: 0.92, gender: 'female' },
2620-        pro_narrator: { pitch: 0.98, rate: 0.95, gender: 'male' },
2621-        pro_grandpa: { pitch: 0.72, rate: 0.88, gender: 'male' },
2622-        pro_fairy: { pitch: 1.35, rate: 1.02, gender: 'female' },
2623-        clone_papa: { pitch: parentVoiceData.papa?.pitch || 0.85, rate: parentVoiceData.papa?.rate || 0.92, gender: 'male' },
2624-        clone_maman: { pitch: parentVoiceData.maman?.pitch || 1.18, rate: parentVoiceData.maman?.rate || 0.92, gender: 'female' }
2625-      };
2626-
2627-      const prof = profiles[currentVoiceNarrator] || profiles.pro_papa;
2628-      utterance.pitch = prof.pitch;
2629-      utterance.rate = prof.rate * currentSpeed;
2630-
2631-      if (voices && voices.length > 0) {
2632-        let bestVoice = null;
2633-        if (prof.gender === 'male') {
2634-          bestVoice = voices.find(v => (v.name.includes('David') || v.name.includes('George') || v.name.includes('Male') || v.name.includes('Daniel') || v.name.includes('Thomas')) && v.lang.startsWith('en')) || voices[0];
2635-        } else {
2636-          bestVoice = voices.find(v => (v.name.includes('Samantha') || v.name.includes('Zira') || v.name.includes('Female') || v.name.includes('Victoria') || v.name.includes('Karen')) && v.lang.startsWith('en')) || voices[0];
2637-        }
2638-        if (bestVoice) utterance.voice = bestVoice;
2639-      }
2640-    }
2641-
2642-    // AUDIO & UTILITIES
2643-    function toggleAudio() {
2644-      if (isSpeaking) {
2645-        stopAudio();
2646-      } else {
2647-        startAudio();
2648-      }
2649-    }
2650-
2651-    function startAudio() {
2652-      if (!('speechSynthesis' in window)) return alert('TTS not supported');
2653-      window.speechSynthesis.cancel();
2654-
2655-      if (!fullPlainString) {
2656-        parseStoryMarkup(currentStory.raw);
2657-      }
2658-      const plain = fullPlainString;
2659-
2660-      const playNarrativeSpeech = () => {
2661-        const utterance = new SpeechSynthesisUtterance(plain);
2662-        utterance.lang = currentAccent;
2663-
2664-        applyVoiceProfileToUtterance(utterance);
2665-
2666-        utterance.onboundary = (e) => {
2667-          if (e.name === 'word') {
2668-            const charIdx = e.charIndex;
2669-            const charLen = e.charLength || 1;
2670-
2671-            const progress = (charIdx / plain.length) * 100;
2672-            const progressFill = document.getElementById('progressFill');
2673-            if (progressFill) progressFill.style.width = Math.min(progress, 100) + "%";
2674-
2675-            // Highlight current word in .reader-scroll
2676-            const wordSpans = document.querySelectorAll('#storyContent .story-word');
2677-            wordSpans.forEach(span => {
2678-              const start = parseInt(span.dataset.start);
2679-              const end = parseInt(span.dataset.end);
2680-              if (charIdx >= start && charIdx < end) {
2681-                span.classList.add('active-spoken-word');
2682-                span.scrollIntoView({ behavior: 'smooth', block: 'nearest', inline: 'nearest' });
2683-              } else {
2684-                span.classList.remove('active-spoken-word');
2685-              }
2686-            });
2687-
2688-            if (autoAdaptiveEnabled) {
2689-              const spokenWord = plain.substring(charIdx, charIdx + charLen).toLowerCase().replace(/[^a-z]/g, '');
2690-              checkSpokenWordForSoundEffects(spokenWord);
2691-            }
2692-          }
2693-        };
2694-
2695-        utterance.onend = () => stopAudio();
2696-        window.speechSynthesis.speak(utterance);
2697-        isSpeaking = true;
2698-        document.getElementById('btnPlay').style.display = 'none';
2699-        document.getElementById('btnStop').style.display = 'flex';
2700-      };
2701-
2702-      if (currentVoiceNarrator.startsWith('clone_')) {
2703-        const role = currentVoiceNarrator.replace('clone_', '');
2704-        const parentData = parentVoiceData[role];
2705-        if (parentData && parentData.audioUrl) {
2706-          isSpeaking = true;
2707-          document.getElementById('btnPlay').style.display = 'none';
2708-          document.getElementById('btnStop').style.display = 'flex';
2709-
2710-          const introAudio = new Audio(parentData.audioUrl);
2711-          introAudio.onended = () => {
2712-            if (isSpeaking) playNarrativeSpeech();
2713-          };
2714-          introAudio.onerror = () => playNarrativeSpeech();
2715-          introAudio.play().catch(() => playNarrativeSpeech());
2716-          return;
2717-        }
2718-      }
2719-
2720-      playNarrativeSpeech();
2721-    }
2722-
2723-    function stopAudio() {
2724-      if ('speechSynthesis' in window) window.speechSynthesis.cancel();
2725-      isSpeaking = false;
2726-      document.getElementById('btnPlay').style.display = 'flex';
2727-      document.getElementById('btnStop').style.display = 'none';
2728-      document.getElementById('progressFill').style.width = '0%';
2729-      document.querySelectorAll('#storyContent .story-word').forEach(span => {
2730-        span.classList.remove('active-spoken-word');
2731-      });
2732-    }
2733-
2734-    function speakWord(w) {
2735-      if (!('speechSynthesis' in window)) return;
2736-      const u = new SpeechSynthesisUtterance(w);
2737-      u.rate = 0.9;
2738-      u.lang = currentAccent;
2739-      window.speechSynthesis.speak(u);
2740-    }
2741-
2742-    function changeSpeed(val) { currentSpeed = parseFloat(val); if (isSpeaking) startAudio(); }
2743-    function changeAccent(val) { currentAccent = val; if (isSpeaking) startAudio(); }
2744-
2745-    function openAiGenerator() { openModal('aiModal'); }
2746-    function openStoryHub() {
2747-      const list = document.getElementById('libraryList');
2748-      list.innerHTML = "";
2749-      allStories.forEach((s) => {
2750-        const item = document.createElement('div');
2751-        item.style = `padding:10px 12px; margin-bottom:8px; border-radius:10px; border:1px solid var(--border); background:${s.id === currentStory.id ? 'rgba(67,56,202,0.15)' : 'var(--surface-variant)'}; display:flex; justify-content:space-between; align-items:center;`;
2752-        
2753-        const infoDiv = document.createElement('div');
2754-        infoDiv.style = "cursor:pointer; flex:1;";
2755-        infoDiv.innerHTML = `
2756-          <div style="font-weight:700; font-size:13px;">${s.title}</div>
2757-          <div style="font-size:11px; color:var(--text-muted);">${s.level} • ${s.theme}</div>
2758-        `;
2759-        infoDiv.onclick = () => { loadStory(s); closeModalDirect('libraryModal'); };
2760-
2761-        const actionsDiv = document.createElement('div');
2762-        actionsDiv.style = "display:flex; gap:6px; align-items:center;";
2763-
2764-        const quizBtn = document.createElement('button');
2765-        quizBtn.className = "btn-pill";
2766-        quizBtn.style = "padding:4px 8px; font-size:11px; background:var(--primary); color:white; border:none;";
2767-        quizBtn.innerText = "🧠 Quiz";
2768-        quizBtn.onclick = (e) => { e.stopPropagation(); openQuizPractice(s); };
2769-
2770-        const readBtn = document.createElement('button');
2771-        readBtn.className = "btn-pill";
2772-        readBtn.style = "padding:4px 8px; font-size:11px;";
2773-        readBtn.innerText = "📖 Read";
2774-        readBtn.onclick = (e) => { e.stopPropagation(); loadStory(s); closeModalDirect('libraryModal'); };
2775-
2776-        actionsDiv.appendChild(quizBtn);
2777-        actionsDiv.appendChild(readBtn);
2778-
2779-        item.appendChild(infoDiv);
2780-        item.appendChild(actionsDiv);
2781-        list.appendChild(item);
2782-      });
2783-      openModal('libraryModal');
2784-    }
2785-
2786-    let activeQuizStory = null;
2787-    let userQuizSelections = {};
2788-
2789-    function openQuizPractice(story) {
2790-      activeQuizStory = story;
2791-      userQuizSelections = {};
2792-      document.getElementById('quizPracticeTitle').innerText = `🧠 Quiz: ${story.title}`;
2793-      const container = document.getElementById('quizPracticeContent');
2794-      container.innerHTML = "";
2795-
2796-      story.quiz.forEach((q, qIdx) => {
2797-        const qBox = document.createElement('div');
2798-        qBox.style = "margin-bottom:14px; padding:12px; border-radius:8px; background:var(--surface); border:1px solid var(--border);";
2799-        
2800-        let qHtml = `<div style="font-weight:600; font-size:13px; margin-bottom:8px;">${qIdx + 1}. ${q.question}</div>`;
2801-        
2802-        if (q.type === 'open') {
2803-          qHtml += `<textarea class="form-input" rows="2" placeholder="Type your personal opinion here..." oninput="userQuizSelections[${qIdx}] = this.value"></textarea>`;
2804-        } else {
2805-          q.options.forEach((opt, optIdx) => {
2806-            qHtml += `
2807-              <label style="display:flex; align-items:center; gap:8px; font-size:12.5px; margin:6px 0; cursor:pointer;">
2808-                <input type="radio" name="quiz_q_${qIdx}" value="${optIdx}" onchange="userQuizSelections[${qIdx}] = ${optIdx}">
2809-                <span>${opt}</span>
2810-              </label>
2811-            `;
2812-          });
2813-        }
2814-        qBox.innerHTML = qHtml;
2815-        container.appendChild(qBox);
2816-      });
2817-
2818-      closeModalDirect('libraryModal');
2819-      openModal('quizPracticeModal');
2820-    }
2821-
2822-    function submitQuizPractice() {
2823-      if (!activeQuizStory) return;
2824-      const container = document.getElementById('quizPracticeContent');
2825-      const qBoxes = container.children;
2826-
2827-      let score = 0;
2828-      let totalMc = 0;
2829-
2830-      activeQuizStory.quiz.forEach((q, qIdx) => {
2831-        const box = qBoxes[qIdx];
2832-        if (q.type === 'open') {
2833-          box.innerHTML += `<div style="margin-top:8px; font-size:11.5px; color:#10b981; font-weight:600;">✅ Personal response recorded!</div>`;
2834-        } else {
2835-          totalMc++;
2836-          const selected = userQuizSelections[qIdx];
2837-          const isCorrect = (selected !== undefined && Number(selected) === q.correct);
2838-          if (isCorrect) score++;
2839-
2840-          const feedback = document.createElement('div');
2841-          feedback.style = `margin-top:8px; padding:6px 10px; border-radius:6px; font-size:11.5px; font-weight:600; background:${isCorrect ? 'rgba(16,185,129,0.15)' : 'rgba(239,68,68,0.15)'}; color:${isCorrect ? '#10b981' : '#ef4444'};`;
2842-          feedback.innerHTML = isCorrect ? `✅ Correct! ${q.explanation}` : `❌ Incorrect. Correct answer: ${q.options[q.correct]}<div style="font-weight:normal; margin-top:2px;">${q.explanation}</div>`;
2843-          box.appendChild(feedback);
2844-        }
2845-      });
2846-
2847-      alert(`Quiz test completed! You scored ${score} out of ${totalMc} multiple choice questions.`);
2848-    }
2849-
2850-    function cycleFontSize() {
2851-      const area = document.getElementById('readerArea');
2852-      area.classList.remove(fontSizes[currentFontSizeIdx]);
2853-      currentFontSizeIdx = (currentFontSizeIdx + 1) % fontSizes.length;
2854-      area.classList.add(fontSizes[currentFontSizeIdx]);
2855-    }
2856-
2857-    function toggleTheme() {
2858-      const isDark = document.documentElement.getAttribute('data-theme') === 'dark';
2859-      document.documentElement.setAttribute('data-theme', isDark ? 'light' : 'dark');
2860-    }
2861-
2862-    const palettes = ['indigo', 'sapphire', 'emerald', 'ruby', 'amethyst', 'amber'];
2863-    let currentPaletteIdx = 0;
2864-    function cyclePalette() {
2865-      currentPaletteIdx = (currentPaletteIdx + 1) % palettes.length;
2866-      document.documentElement.setAttribute('data-palette', palettes[currentPaletteIdx]);
2867-    }
2868-
2869-    function openModal(id) {
2870-      const modal = document.getElementById(id);
2871-      if (modal) modal.classList.add('active');
2872-    }
2873-
2874-    function closeModalDirect(id) {
2875-      const modal = document.getElementById(id);
2876-      if (modal) modal.classList.remove('active');
2877-    }
2878-
2879-    function closeSheet(e, id) {
2880-      if (e.target.id === id || e.target.classList.contains('modal-overlay')) {
2881-        closeModalDirect(id);
2882-      }
2883-    }
2884-
2885-    // --- AI COMPANION (LINGOBOT) LOGIC ---
2886-    let companionHistory = [];
2887-
2888-    function openAiCompanion() {
2889-      const container = document.getElementById('companionChatContainer');
2890-      if (companionHistory.length === 0) {
2891-        const welcomeText = `Hello Abdelmalek! 👋 I am **LingoBot**, your AI English Tutor.\n\nWe are currently reading **"${currentStory ? currentStory.title : 'a story'}"** (${currentStory ? currentStory.level : 'A2'} level). How can I assist your learning today?`;
2892-        companionHistory.push({ sender: 'bot', text: welcomeText });
2893-        renderCompanionChat();
2894-      }
2895-      openModal('aiCompanionModal');
2896-    }
2897-
2898-    function renderCompanionChat() {
2899-      const container = document.getElementById('companionChatContainer');
2900-      container.innerHTML = "";
2901-      companionHistory.forEach((msg) => {
2902-        const isUser = msg.sender === 'user';
2903-        const bubble = document.createElement('div');
2904-        bubble.style = `max-width:85%; padding:10px 14px; border-radius:14px; font-size:12.5px; line-height:1.45; ${
2905-          isUser
2906-            ? 'align-self:flex-end; background:var(--primary); color:white; border-bottom-right-radius:2px;'
2907-            : 'align-self:flex-start; background:var(--surface); color:var(--text-main); border:1px solid var(--border); border-bottom-left-radius:2px;'
2908-        }`;
2909-        
2910-        let formattedText = msg.text.replace(/\*\*(.*?)\*\*/g, '<strong>$1</strong>').replace(/\n/g, '<br/>');
2911-        
2912-        if (!isUser) {
2913-          bubble.innerHTML = `
2914-            <div style="display:flex; justify-content:space-between; align-items:flex-start; gap:8px;">
2915-              <div>${formattedText}</div>
2916-              <button class="icon-btn" style="padding:2px 6px; font-size:11px; flex-shrink:0;" onclick="speakWord('${msg.text.replace(/'/g, "\\'").replace(/"/g, '&quot;').replace(/\n/g, ' ')}')">🔊</button>
2917-            </div>
2918-          `;
2919-        } else {
2920-          bubble.innerHTML = formattedText;
2921-        }
2922-        container.appendChild(bubble);
2923-      });
2924-      container.scrollTop = container.scrollHeight;
2925-    }
2926-
2927-    function sendQuickPrompt(promptText) {
2928-      document.getElementById('companionInput').value = promptText;
2929-      sendCompanionMessage();
2930-    }
2931-
2932-    async function sendCompanionMessage() {
2933-      const input = document.getElementById('companionInput');
2934-      const text = input.value.trim();
2935-      if (!text) return;
2936-
2937-      input.value = "";
2938-      companionHistory.push({ sender: 'user', text: text });
2939-      renderCompanionChat();
2940-
2941-      // Show typing indicator
2942-      const container = document.getElementById('companionChatContainer');
2943-      const typingDiv = document.createElement('div');
2944-      typingDiv.id = "companionTyping";
2945-      typingDiv.style = "align-self:flex-start; padding:8px 12px; border-radius:12px; background:var(--surface); font-size:11px; color:var(--text-muted); font-style:italic;";
2946-      typingDiv.innerText = "🤖 LingoBot is thinking...";
2947-      container.appendChild(typingDiv);
2948-      container.scrollTop = container.scrollHeight;
2949-
2950-      const reply = await generateCompanionResponse(text);
2951-      
2952-      const typingEl = document.getElementById('companionTyping');
2953-      if (typingEl) typingEl.remove();
2954-
2955-      companionHistory.push({ sender: 'bot', text: reply });
2956-      renderCompanionChat();
2957-    }
2958-
2959-    async function generateCompanionResponse(userText) {
2960-      const apiKey = document.getElementById('aiApiKey') ? document.getElementById('aiApiKey').value.trim() : "";
2961-      const storyTitle = currentStory ? currentStory.title : "English Story";
2962-      const storyLevel = currentStory ? currentStory.level : "B1";
2963-      const storyText = currentStory ? currentStory.raw : "";
2964-
2965-      if (apiKey) {
2966-        try {
2967-          const systemPrompt = `You are LingoBot, an encouraging English language tutor companion in the LingoStory app. The user is learning English at ${storyLevel} level. The current story being read is "${storyTitle}". Here is the raw story context:\n"${storyText.substring(0, 800)}"\n\nKeep your answer concise (2-4 sentences), friendly, clear, and highly educational. Highlight key vocabulary with **bold** text.`;
2968-          
2969-          const resp = await fetch(`https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash:generateContent?key=${apiKey}`, {
2970-            method: 'POST',
2971-            headers: { 'Content-Type': 'application/json' },
2972-            body: JSON.stringify({
2973-              contents: [
2974-                { parts: [{ text: `${systemPrompt}\n\nUser Question: ${userText}` }] }
2975-              ]
2976-            })
2977-          });
2978-
2979-          const data = await resp.json();
2980-          if (data.candidates && data.candidates[0].content.parts[0].text) {
2981-            return data.candidates[0].content.parts[0].text;
2982-          }
2983-        } catch (e) {
2984-          console.warn("Gemini API call failed, using intelligent companion fallback:", e);
2985-        }
2986-      }
2987-
2988-      // Intelligent Fallback Companion Engine
2989-      const lower = userText.toLowerCase();
2990-      if (lower.includes('moral') || lower.includes('lesson')) {
2991-        return `💡 **Core Moral of "${storyTitle}"**: The central lesson teaches us that kindness, patience, and creative problem-solving overcome difficult obstacles. Keep practicing these themes in your everyday English!`;
2992-      } else if (lower.includes('conversation') || lower.includes('practice chat')) {
2993-        return `🗣️ **Let's Practice!** Imagine you were in "${storyTitle}". How would you feel if you met the main character today? Reply in 1 or 2 simple sentences in English!`;
2994-      } else if (lower.includes('quiz') || lower.includes('vocabulary')) {
2995-        return `📝 **Quick Vocabulary Check for "${storyTitle}"**:\n1. What does **"kind-hearted"** mean? (a) Generous & caring (b) Angry\n2. Which word means "extremely beautiful"? (**magnificent**)\n\nTry answering in our chat!`;
2996-      } else if (lower.includes('grammar') || lower.includes('rules')) {
2997-        return `🔍 **Grammar Insight**: Notice how "${storyTitle}" uses the **Past Simple tense** (e.g., *lived*, *discovered*, *trapped*) to narrate sequential story events. Tapping highlighted words in the reader gives you instant tense breakdowns!`;
2998-      } else {
2999-        return `🤖 **Great question!** In "${storyTitle}" (${storyLevel} Level), we focus on building **vocabulary** and understanding **sentence structures**. Would you like me to explain a specific word or give you a quick 3-question quiz?`;
3000-      }
3001-    }
3002-
3003-    // --- READERS & LISTENERS FEEDBACK SYSTEM ---
3004-    let selectedStarRating = 5;
3005-    let savedFeedbacks = JSON.parse(localStorage.getItem('lingo_feedbacks_v1')) || [
3006-      {
3007-        name: "Sarah Mansour",
3008-        age: 26,
3009-        email: "sarah.m@example.com",
3010-        role: "Reader & Listener",
3011-        rating: 5,
3012-        comment: "The native audio narration and interactive grammar annotations make reading English so clear and enjoyable!",
3013-        storyTitle: "Cinderella and the Glass Slipper",
3014-        date: "2026-09-01"
3015-      },
3016-      {
3017-        name: "David Chen",
3018-        age: 31,
3019-        email: "david.chen@example.com",
3020-        role: "English Learner",
3021-        rating: 5,
3022-        comment: "Loved listening to the narrator while following along with highlighted vocabulary and Smart Lexis synonyms.",
3023-        storyTitle: "The Lion and the Mouse",
3024-        date: "2026-09-02"
3025-      }
3026-    ];
3027-
3028-    function openFeedbackModal() {
3029-      openModal('feedbackModal');
3030-    }
3031-
3032-    function setStarRating(rating) {
3033-      selectedStarRating = rating;
3034-      const stars = document.querySelectorAll('#starRatingContainer span, #modalStarRatingContainer span');
3035-      stars.forEach((star, idx) => {
3036-        if (idx < rating) {
3037-          star.style.color = "#f59e0b"; // Gold star
3038-        } else {
3039-          star.style.color = "#e5e7eb";
3040-        }
3041-      });
3042-    }
3043-
3044-    function handleFeedbackSubmit(e) {
3045-      e.preventDefault();
3046-      const name = document.getElementById('fbName').value.trim();
3047-      const age = parseInt(document.getElementById('fbAge').value.trim());
3048-      const email = document.getElementById('fbEmail').value.trim();
3049-      const role = document.getElementById('fbRole').value;
3050-      const comment = document.getElementById('fbComment').value.trim();
3051-
3052-      if (!name || !age || !email || !comment) {
3053-        alert("Please fill in all required fields (Name, Age, Email, and Comments).");
3054-        return;
3055-      }
3056-
3057-      const newFeedback = {
3058-        name,
3059-        age,
3060-        email,
3061-        role,
3062-        rating: selectedStarRating,
3063-        comment,
3064-        storyTitle: currentStory ? currentStory.title : "LingoStory App",
3065-        date: new Date().toLocaleDateString()
3066-      };
3067-
3068-      savedFeedbacks.unshift(newFeedback);
3069-      localStorage.setItem('lingo_feedbacks_v1', JSON.stringify(savedFeedbacks));
3070-
3071-      // Reset Form
3072-      document.getElementById('fbComment').value = "";
3073-      alert("Thank you! Your feedback has been submitted successfully.");
3074-      renderFeedbacks();
3075-    }
3076-
3077-    function handleModalFeedbackSubmit(e) {
3078-      e.preventDefault();
3079-      const name = document.getElementById('modalFbName').value.trim();
3080-      const age = parseInt(document.getElementById('modalFbAge').value.trim());
3081-      const email = document.getElementById('modalFbEmail').value.trim();
3082-      const role = document.getElementById('modalFbRole').value;
3083-      const comment = document.getElementById('modalFbComment').value.trim();
3084-
3085-      if (!name || !age || !email || !comment) {
3086-        alert("Please fill in all required fields.");
3087-        return;
3088-      }
3089-
3090-      const newFeedback = {
3091-        name,
3092-        age,
3093-        email,
3094-        role,
3095-        rating: selectedStarRating,
3096-        comment,
3097-        storyTitle: currentStory ? currentStory.title : "LingoStory App",
3098-        date: new Date().toLocaleDateString()
3099-      };
3100-
3101-      savedFeedbacks.unshift(newFeedback);
3102-      localStorage.setItem('lingo_feedbacks_v1', JSON.stringify(savedFeedbacks));
3103-
3104-      document.getElementById('modalFbComment').value = "";
3105-      closeModalDirect('feedbackModal');
3106-      alert("Thank you! Your feedback has been submitted successfully.");
3107-      renderFeedbacks();
3108-    }
3109-
3110-    function renderFeedbacks() {
3111-      const list = document.getElementById('feedbackList');
3112-      const countEl = document.getElementById('fbCount');
3113-      if (!list) return;
3114-
3115-      countEl.innerText = savedFeedbacks.length;
3116-      list.innerHTML = "";
3117-
3118-      if (savedFeedbacks.length === 0) {
3119-        list.innerHTML = '<div style="font-size:12px; color:var(--text-muted); font-style:italic;">No feedback submitted yet. Be the first reader to leave a review!</div>';
3120-        return;
3121-      }
3122-
3123-      savedFeedbacks.forEach((fb) => {
3124-        const starsStr = "★".repeat(fb.rating) + "☆".repeat(5 - fb.rating);
3125-        const card = document.createElement('div');
3126-        card.style = "padding:10px 12px; background:var(--surface-variant); border:1px solid var(--border); border-radius:10px; font-size:12px;";
3127-        card.innerHTML = `
3128-          <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:4px;">
3129-            <div style="font-weight:700; color:var(--primary);">${escapeHtml(fb.name)} <span style="font-size:10px; font-weight:normal; color:var(--text-muted);">(Age ${fb.age} • ${escapeHtml(fb.role)})</span></div>
3130-            <div style="color:#f59e0b; font-size:11px;">${starsStr}</div>
3131-          </div>
3132-          <div style="color:var(--text-main); font-size:11.5px; line-height:1.4; margin-bottom:4px;">"${escapeHtml(fb.comment)}"</div>
3133-          <div style="font-size:10px; color:var(--text-muted); display:flex; justify-content:space-between;">
3134-            <span>📖 ${escapeHtml(fb.storyTitle)}</span>
3135-            <span>✉️ ${escapeHtml(fb.email)} • ${fb.date}</span>
3136-          </div>
3137-        `;
3138-        list.appendChild(card);
3139-      });
3140-    }
3141-
3142-    function escapeHtml(str) {
3143-      if (!str) return "";
3144-      return str.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/"/g, "&quot;").replace(/'/g, "&#039;");
3145-    }
3146-
3147-    window.onload = init;
3148-  </script>
3149-</body>
3150-</html>
