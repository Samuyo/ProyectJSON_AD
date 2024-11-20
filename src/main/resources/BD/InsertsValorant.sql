USE VALORANT;

INSERT INTO ROLES (NOMBRE_ROL, DESCRIP_ROL) VALUES 
('INICIADOR', 'Los iniciadores son especialistas en crear situaciones para iniciar combates, abriendo caminos para el equipo.'),
('CONTROLADOR', 'Los controladores son expertos en cortar la visión enemiga y facilitar el ataque y defensa en puntos estratégicos.'),
('DUELISTA', 'Los duelistas son asesinos autosuficientes que buscan enfrentamientos directos y son capaces de obtener múltiples eliminaciones por sí mismos.'),
('CENTINELA', 'Los centinelas son expertos en asegurar áreas y proteger a sus compañeros de equipo con herramientas defensivas.');


INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Jett', 'Jett es una duelista con gran agilidad. Su estilo de juego es veloz y evasivo, lo que la hace difícil de atrapar. Ella puede moverse rápidamente por el campo de batalla y atacar con letal precisión.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='Duelista'));


INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB) VALUES 
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Jett'), 
    'Explosión de Nube', 
    'Lanza una nube de niebla que bloquea la visión durante unos segundos. Úsala para crear cobertura y desorientar a los enemigos.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Jett'), 
    'Corriente Ascendente', 
    'Propúlsate hacia arriba rápidamente. Esta habilidad permite a Jett acceder a posiciones elevadas y escapar de situaciones peligrosas con rapidez.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Jett'), 
    'Viento de Cola', 
    'Desplázate rápidamente hacia adelante. Usa esta habilidad para esquivar ataques y cerrar la distancia con los enemigos de manera instantánea.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Jett'), 
    'Tormenta de Cuchillas', 
    'Lanza cuchillos mortales que infligen daño significativo a los enemigos. Esta habilidad es perfecta para combates a corta distancia y puede asegurar eliminaciones rápidas.'
);

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Gekko', 'Gekko es un iniciador que despliega criaturas de su arsenal para desorientar y controlar el campo de batalla, proporcionando utilidad y ventaja estratégica a su equipo.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='INICIADOR'));

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB) VALUES 
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Gekko'), 
    'Dizzy', 
    'Dizzy lanza ráfagas explosivas que ciegan a los enemigos que están en su línea de visión. Una vez lanzado, Dizzy se despliega en el aire y dispara ráfagas a los enemigos en su campo de visión.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Gekko'), 
    'Wingman', 
    'Wingman se desplaza hacia adelante y busca enemigos. Al detectar un enemigo, Wingman lanza una explosión de conmoción que aturde a todos los enemigos cercanos. Además, Wingman puede ser utilizado para plantar o desactivar el Spike.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Gekko'), 
    'Mosh Pit', 
    'Mosh se lanza como una granada que se expande tras una breve demora y explota en un área grande, infligiendo daño significativo a todos los enemigos dentro del área afectada.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Gekko'), 
    'Thrash', 
    'Thrash se desplaza hacia adelante y puede ser dirigido a un área específica. Al llegar a su destino, Thrash se lanza hacia adelante y se estrella contra el suelo, aturdiendo a todos los enemigos en un área grande.'
);

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Omen', 'Omen es un controlador sigiloso que puede desatar el caos desde las sombras, cegando a sus enemigos y teleportándose a nuevas ubicaciones para tomar ventaja en el combate.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CONTROLADOR'));

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB) VALUES 
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Omen'), 
    'Paranoia', 
    'Lanza un proyectil de sombras en línea recta, atravesando paredes y cegando a todos los jugadores que toca.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Omen'), 
    'Velo Tenebroso', 
    'Equipa una esfera de sombras y lanza una nube de sombra que bloquea la visión en su área. Puede cargarse para aumentar la distancia.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Omen'), 
    'Pasos Sombríos', 
    'Equipa una habilidad que permite elegir una ubicación cercana para teletransportarse después de un breve retraso.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Omen'), 
    'Desde las Sombras', 
    'Selecciona cualquier lugar en el mapa para teletransportarse y aparecer en forma de sombra. Si Omen muere en su forma de sombra, volverá a su ubicación original.'
);

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Chamber', 'Chamber es un centinela altamente sofisticado con habilidades que le permiten controlar el campo de batalla con precisión letal. Puede colocar trampas, teletransportarse y usar un armamento avanzado para mantener a raya a sus enemigos.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CENTINELA'));

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB) VALUES 
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Chamber'), 
    'Marca Registrada', 
    'Coloca una trampa que escanea el área en busca de enemigos. Al detectar un enemigo, la trampa reduce significativamente la velocidad de movimiento del enemigo atrapado.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Chamber'), 
    'Cazador de Cabezas', 
    'Equipa una pistola pesada que dispara con precisión letal. Cada disparo cuesta una cantidad de créditos y tiene un gran impacto.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Chamber'), 
    'Rendezvous', 
    'Coloca un anclaje de teletransporte. Mientras estés en el alcance del anclaje, puedes reactivar la habilidad para teletransportarte instantáneamente al anclaje. El anclaje puede ser recogido y redeployado.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Chamber'), 
    'Tour de Force', 
    'Equipa un poderoso rifle de francotirador que mata a cualquier enemigo con un impacto directo. Las muertes crean un área que ralentiza a los jugadores atrapados en su radio.'
);

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Neon', 'Neon es una duelista que puede moverse a gran velocidad y usar sus habilidades eléctricas para sorprender y eliminar a sus enemigos rápidamente.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='DUELISTA'));

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB) VALUES 
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Neon'), 
    'Carrera Relámpago', 
    'Neon corre a gran velocidad durante un corto período de tiempo, permitiéndole cruzar el campo de batalla rápidamente.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Neon'), 
    'Rayo Aturdidor', 
    'Lanza un rayo eléctrico que aturde a los enemigos en su camino, dejándolos vulnerables a los ataques.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Neon'), 
    'Campos Electrostáticos', 
    'Crea un área de energía eléctrica que inflige daño constante a los enemigos dentro del área.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Neon'), 
    'Explosión Relámpago', 
    'Neon desata una explosión masiva de energía eléctrica, causando gran daño a todos los enemigos en su radio.'
);

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Reyna', 'Reyna es una duelista que se alimenta de las muertes de sus enemigos para volverse más poderosa, curarse y volverse invulnerable temporalmente.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='DUELISTA'));

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB) VALUES 
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Reyna'), 
    'Devorar', 
    'Recoge orbes de las almas de los enemigos muertos para curarse durante un breve período de tiempo. Si es usada junto con Emperatriz, la curación es automática y no consume carga.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Reyna'), 
    'Despreciar', 
    'Usa un orbe de alma para volverse invulnerable e invisible durante un breve período de tiempo. La duración se incrementa si se usa junto con Emperatriz.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Reyna'), 
    'Cegar', 
    'Lanza un ojo etéreo que puede atravesar paredes. Este ojo ciega a todos los enemigos que lo miran fijamente.'
),
(
    (SELECT ID_AG from AGENTES where NOMBRE_AG='Reyna'), 
    'Emperatriz', 
    'Entra en un estado de frenesí donde aumenta su tasa de fuego y reduce significativamente el tiempo de reutilización de sus habilidades. Las eliminaciones reinician la duración de esta habilidad.'
);

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Sage', 'Sage es una centinela que proporciona un sólido soporte defensivo a su equipo. Sus habilidades permiten curar a sus aliados, revivir a los caídos y bloquear el avance enemigo con barreras y orbes lentificadores.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CENTINELA'));

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB) VALUES 
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Sage'), 
    'Orbe Curativo', 
    'Lanza un orbe que cura gradualmente a un aliado o a sí misma durante varios segundos.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Sage'), 
    'Orbe de Lentitud', 
    'Lanza un orbe que, al impactar contra el suelo, crea un campo que ralentiza a todos los que lo atraviesan.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Sage'), 
    'Orbe Barrera', 
    'Crea una barrera sólida y destructible que puede bloquear el paso enemigo o proteger una área crítica.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Sage'), 
    'Resurrección', 
    'Revive a un aliado caído, devolviéndole a la vida con salud completa.'
);

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Killjoy', 'Killjoy es una centinela que usa su ingenio y tecnología avanzada para controlar el campo de batalla. Sus dispositivos pueden revelar, dañar y ralentizar a los enemigos, y su ultimate puede deshabilitar a todos los enemigos en un área amplia.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CENTINELA'));

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB) VALUES 
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Killjoy'), 
    'Nanoenjambre', 
    'Lanza una granada que se despliega en un enjambre de nanobots, infligiendo daño a los enemigos que se encuentren en el área afectada.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Killjoy'), 
    'Torreta', 
    'Despliega una torreta que dispara a los enemigos en un cono frontal, proporcionándote información sobre su ubicación y ayudando a infligir daño.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Killjoy'), 
    'Bot de Alarmas', 
    'Despliega un bot que caza enemigos y detona cuando están cerca, aplicando un efecto de vulnerabilidad a los enemigos alcanzados.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Killjoy'), 
    'Confinamiento', 
    'Despliega un dispositivo que, tras un breve retraso, detiene y deshabilita a todos los enemigos en un área grande, dejándolos vulnerables a ataques.'
);

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Viper', 'Viper es una controladora que usa una variedad de dispositivos químicos para controlar el campo de batalla. Sus habilidades tóxicas pueden bloquear la visión enemiga, infligir daño y dividir a los oponentes.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CONTROLADOR'));

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB) VALUES 
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Viper'), 
    'Cortina Tóxica', 
    'Despliega una larga línea de emisores que, una vez activados, crean una pared alta de gas tóxico que bloquea la visión y daña a los enemigos que la atraviesan.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Viper'), 
    'Nube Venenosa', 
    'Lanza un dispositivo que se activa para crear una nube de gas venenoso. Puede ser reutilizada varias veces y recogida para ser lanzada de nuevo.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Viper'), 
    'Mordedura de Serpiente', 
    'Dispara un proyectil de toxina que explota al impactar en el suelo, creando un charco de ácido que daña a los enemigos que lo tocan.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Viper'), 
    'Pozo de la Víbora', 
    'Expulsa una nube de gas tóxico en un área grande, reduciendo la visión y la salud máxima de los enemigos dentro de ella. La nube dura indefinidamente mientras Viper permanezca dentro de la nube.'
);

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Harbor', 'Harbor es un controlador que utiliza sus habilidades acuáticas para manipular el campo de batalla, creando barreras de agua para bloquear la visión y proteger a sus aliados.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CONTROLADOR'));

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB) VALUES 
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Harbor'), 
    'Muro de Agua', 
    'Crea un muro de agua que bloquea la visión y desacelera a los enemigos que lo atraviesan.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Harbor'), 
    'Cascada', 
    'Lanza una ola de agua que avanza en línea recta, atravesando paredes y dañando a los enemigos en su camino.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Harbor'), 
    'Marea Alta', 
    'Levanta una barrera de agua en una ubicación seleccionada, bloqueando la visión y proporcionando cobertura.'
),
(
    (SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG='Harbor'), 
    'Tormenta Marina', 
    'Invoca una tormenta masiva que cubre una amplia área, cegando y ralentizando a los enemigos atrapados en su radio.'
);
