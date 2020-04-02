(defn simple-conversation []
  (print "Hi. Tell me about yourself.")
  (setv name (input "what is your name?"))
  (setv age (input "what is your age"))
  (print (+ "hi " name "! I see you are" age "years old.")))
(simple-conversation)
