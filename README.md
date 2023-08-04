![banner](banner_dark.png#gh-dark-mode-only)
![banner](banner_light.png#gh-light-mode-only)

`⚠️ NOTE:` For now only among us 2020.9.9 protocol is supported!

# Bakkastom

[![license](https://img.shields.io/github/license/Bakkastom/Bakkastom?style=for-the-badge&color=b2204c)](../LICENSE)
[![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=for-the-badge)](https://github.com/RichardLitt/standard-readme)  
[![javadocs](https://img.shields.io/badge/documentation-javadocs-4d7a97?style=for-the-badge)](https://bakkastom.github.io/Bakkastom/)
[![wiki](https://img.shields.io/badge/documentation-wiki-74aad6?style=for-the-badge)](https://wiki.bakkastom.net/)
[![discord-banner](https://img.shields.io/discord/706185253441634317?label=discord&style=for-the-badge&color=7289da)](https://discord.gg/pkFRvqB)

Bakkastom is an open-source library that enables developers to create their own Among Us server software, without any code from Innersloth.

The main difference between Innersloth's vanilla server and a bakkastom-based server, is that ours does not contain any features by default!
However, we have a complete API which is designed to allow you to make anything possible, with ease.

This is a developer API not meant to be used by end-users. Replacing Impostor with this **will not work** since we do not implement any of their APIs.

# Table of contents
- [Install](#install)
- [Usage](#usage)
- [Why Bakkastom?](#why-bakkastom)
- [Advantages & Disadvantages](#advantages-and-disadvantages)
- [API](#api)
- [Credits](#credits)
- [Contributing](#contributing)
- [License](#license)

# Install
Bakkastom is not installed like Impostor.
As Bakkastom is a Java library, it must be loaded the same way any other Java library may be loaded.
This means you need to add Bakkastom as a dependency, add your code and compile by yourself.

For adding the required repositories and dependencies, [check this out](https://wiki.bakkastom.net/setup/dependencies)

The newest version can be found [here: ![](https://jitpack.io/v/Bakkastom/Bakkastom.svg)](https://jitpack.io/#Bakkastom/Bakkastom)

> Our own WIP implementation for Vanilla can be found [here](https://github.com/Bakkastom/VanillaReimplementation).

# Usage
An example of how to use the Bakkastom library is available [here](/demo).
Alternatively you can check the official [wiki](https://wiki.bakkastom.net/) or the [javadocs](https://bakkastom.github.io/Bakkastom/).

# Why Bakkastom?
Among Us has evolved a lot since its release, most of the servers today do not take advantage of vanilla features and even have to struggle because of them.
Our target audience is those who want to make a server that benefits little from vanilla features. e.g. creative, kitpvp.
The goal is to offer more performance for those who need it.
In other words, it makes sense to use Bakkastom when it takes less time to implement every missing vanilla feature you want than removing every vanilla feature that will slow you down.

# Advantages and Disadvantages
Bakkastom isn't perfect, our choices make it much better for some cases, worse for some others.

## Advantages
* Remove the overhead of vanilla features
* Multi-threaded
* Instance system (Collections of blocks and entities) which is much more scalable than worlds
* Open-source
* Modern API
* No more legacy NMS

## Disadvantages
* Does not work with Impostor plugins or mods
* Does not work with older clients (using a proxy with ViaBackwards is possible)
* Bad for those who want a vanilla experience
* Longer to develop something playable
* Multi-threaded environments need extra consideration

# API
Even if we do not include anything by default in the game, we simplify the way you add them, here is a preview.

## Instances
It is our major concept, worlds are great for survival with friends, but when it scales up it can become unmanageable. The best examples can be found in Skyblock or minigames, not being able to separate each part properly and being forced to save everything in files, not to say the overhead caused by unnecessary data contained in them. Instances are a lightweight solution to it, being able to have every chunk in memory only, copying and sending it to another player in no time, with custom serialization and much more...

Being able to create instances directly on the go is a must-have, we believe it can push many more projects forward.

Instances also come with performance benefits, unlike some others which will be fully single-threaded or maybe using one thread per world we are using a set number of threads (pool) to manage all chunks independently from instances, meaning using more CPU power.

## Blocks
Bakkastom by default does not know what is a chest, you will have to tell him that it opens an inventory. 
Every "special blocks" (which aren't only visual) need a specialized handler. After applying this handler, you have a block that can be placed anywhere simply.
However, all blocks are visually there, they just won't have interaction by default.

## Entities
The terms "passive" or "aggressive" monsters do not exist, nobody stops you from making a flying chicken rushing into any players coming too close, doing so with NMS is a real mess because of obfuscation and the large inheritance.

## Inventories
It is a field where Among Us evolved a lot, inventories are now used a lot as client<->server interface with clickable items and callback, we support these interactions natively without the need of programming your solution.

## Commands
Commands are the simplest way of communication between clients and server. Since 1.13 Among Us has incorporated a new library denominated "Brigadier", we then integrated an API designed to use the full potential of args types.

# Credits
* The [contributors](https://github.com/Bakkastom/Bakkastom/graphs/contributors) of the project
* [The Among Us Coalition](https://wiki.vg/) and [`#mcdevs`](https://github.com/mcdevs) -
   protocol and file formats research.
* [The Among Us Wiki](https://Among Us.gamepedia.com/Among Us_Wiki) for all their useful info
* [JProfiler](https://www.ej-technologies.com/products/jprofiler/overview.html) for their amazing Java profiler

# Contributing
See [the contributing file](CONTRIBUTING.md)!
All WIP features are previewed as Draft PRs

# License
This project is licensed under the [Apache License Version 2.0](../LICENSE).


